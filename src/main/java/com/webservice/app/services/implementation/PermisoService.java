package com.webservice.app.services.implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.LugarConverter;
import com.webservice.app.converters.PermisoDiarioConverter;
import com.webservice.app.converters.PermisoPeriodoConverter;
import com.webservice.app.converters.PersonaConverter;
import com.webservice.app.converters.RodadoConverter;
import com.webservice.app.entities.Lugar;
import com.webservice.app.entities.Permiso;
import com.webservice.app.entities.PermisoDiario;
import com.webservice.app.entities.PermisoPeriodo;
import com.webservice.app.entities.Persona;
import com.webservice.app.models.FechaBusquedaModel;
import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.models.PersonaModel;
import com.webservice.app.models.RodadoModel;
import com.webservice.app.repositories.IPermisoPeriodoRepository;
import com.webservice.app.repositories.IPermisoRepository;
import com.webservice.app.repositories.IPersonaRepository;
import com.webservice.app.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {

	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;

	@Autowired
	@Qualifier("permisoDiarioModel")
	private PermisoDiarioConverter permisoDiarioModel;

	@Autowired
	@Qualifier("lugarModel")
	private LugarConverter lugarModel;

	@Autowired
	@Qualifier("permisoPeriodoModel")
	private PermisoPeriodoConverter permisoPeriodoModel;

	@Autowired
	@Qualifier("rodadoModel")
	private RodadoConverter rodadoConverter;

	@Autowired
	@Qualifier("personaModel")
	private PersonaConverter personaConverter;
	
	@Autowired
	@Qualifier("lugarService")
	private LugarService lugarService;

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService personaService;

	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;


	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	public Permiso findByIdPermiso(int idPermiso) {
		return permisoRepository.findByIdPermiso(idPermiso);
	}
	
	public Permiso findByPersona(PersonaModel persona) {
		return permisoRepository.findByPersona(personaRepository.findByDni(persona.getDni()));
	}
	// ALTA PERMISO

	public void altaPermiso(PermisoModel permisoModel) throws Exception {
		try {

			if (permisoModel instanceof PermisoDiarioModel) {
				Permiso permiso = permisoDiarioModel.modelToEntity((PermisoDiarioModel) permisoModel);
				permiso.getDesdeHasta().add(lugarService.findById(permisoModel.getLugarOrigenModel().getIdLugar()));
				permiso.getDesdeHasta().add(lugarService.findById(permisoModel.getLugarDestinoModel().getIdLugar()));
				Persona persona= personaRepository.findByDni(permisoModel.getPersona().getDni());
				if(!persona.equals(null)) {
					permiso.setPersona(persona);
				}
				permisoRepository.save(permiso);
			}
			if (permisoModel instanceof PermisoPeriodoModel) {
				Permiso permiso = permisoPeriodoModel.modelToEntity((PermisoPeriodoModel) permisoModel);
				permiso.getDesdeHasta().add(lugarService.findById(permisoModel.getLugarOrigenModel().getIdLugar()));
				permiso.getDesdeHasta().add(lugarService.findById(permisoModel.getLugarDestinoModel().getIdLugar()));
				permisoRepository.save(permiso);
			}
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación,error al ingresar los datos o el permiso ya existe");
		}
	}

	// TRAER PERMISO PERIODO POR PERSONA

	public PermisoPeriodoModel findByPersonaPeriodo(long dni) throws Exception {
		try {
			PermisoPeriodo permiso = (PermisoPeriodo) permisoRepository.findByPersona(personaService.findByDni(dni));
			Hibernate.initialize(permiso.getRodado());
			PermisoPeriodoModel retorno = permisoPeriodoModel.entityToModel(permiso);
			Iterator<Lugar> it = permiso.getDesdeHasta().iterator();
			while (it.hasNext()) {
				retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
			}
			return retorno;
		} catch (Exception e) {
			throw new Exception("No se ha encontrado resultados");
		}
	}

	// TRAER PERMISO DIARIO POR PERSONA

	public PermisoDiarioModel findByPersonaDiario(long dni) throws Exception {
		try {
			PermisoDiario permiso = (PermisoDiario) permisoRepository.findByPersona(personaService.findByDni(dni));
			PermisoDiarioModel retorno = permisoDiarioModel.entityToModel(permiso);
			Iterator<Lugar> it = permiso.getDesdeHasta().iterator();
			while (it.hasNext()) {
				retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
			}
			return retorno;
		} catch (Exception e) {
			throw new Exception("No se ha encontrado resultados");
		}
	}

	// TRAER PERMISO PERIODO POR RODADO

	public PermisoPeriodoModel findByRodado(RodadoModel rodadoModel) throws Exception {
		try {
			PermisoPeriodo permiso = (PermisoPeriodo) permisoPeriodoRepository
					.findByRodado(rodadoService.findByDominioVehiculo(rodadoModel));
			Hibernate.initialize(permiso.getRodado());
			PermisoPeriodoModel retorno = permisoPeriodoModel.entityToModel(permiso);
			Iterator<Lugar> it = permiso.getDesdeHasta().iterator();
			while (it.hasNext()) {
				retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
			}
			return retorno;

		} catch (Exception e) {
			throw new Exception("No se ha encontrado resultados");
		}
	}

	// TRAER PERMISO ACTIVO

	public List<PermisoModel> findByActivoPermiso(FechaBusquedaModel fecha) throws Exception {

		try {
			List<PermisoModel> permisos = new ArrayList<PermisoModel>();
			List<Permiso> lstPermiso = permisoRepository.findByActivoPermiso(
					LocalDate.parse(fecha.getFechaDesde(), formatter),
					LocalDate.parse(fecha.getFechaHasta(), formatter));

			for (Permiso p : lstPermiso) {
				Hibernate.initialize(p.getDesdeHasta());
				if (p instanceof PermisoPeriodo) {
					PermisoPeriodo permiso = (PermisoPeriodo) p;
					Hibernate.initialize(permiso.getRodado());
					PermisoPeriodoModel retorno = permisoPeriodoModel.entityToModel(permiso);
					Iterator<Lugar> it = p.getDesdeHasta().iterator();
					while (it.hasNext()) {
						retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
					}
					if (p.activo(p, LocalDate.parse(fecha.getFechaHasta(), formatter))) {
						permisos.add(retorno);
					}
				}

				if (p instanceof PermisoDiario) {
					PermisoDiario permiso = (PermisoDiario) p;
					PermisoDiarioModel retorno = permisoDiarioModel.entityToModel(permiso);
					Iterator<Lugar> it = p.getDesdeHasta().iterator();
					while (it.hasNext()) {
						retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
					}
					if (p.activo(p, LocalDate.parse(fecha.getFechaHasta(), formatter))) {
						permisos.add(retorno);
					}

				}

			}

			return permisos;

		} catch (Exception e) {
			throw new Exception("No se ha encontrado resultados");
		}

	}

	public List<PermisoModel> findByActivoPermisoLugares(FechaBusquedaModel fecha) throws Exception {

		try {
			List<PermisoModel> permisos = new ArrayList<PermisoModel>();
			List<Permiso> lstPermiso = permisoRepository.findByActivoPermiso(
					LocalDate.parse(fecha.getFechaDesde(), formatter),
					LocalDate.parse(fecha.getFechaHasta(), formatter));
			Lugar lOrigen = lugarService.findById(fecha.getLugarOrigenModel().getIdLugar());
			Lugar lDestino = lugarService.findById(fecha.getLugarDestinoModel().getIdLugar());

			for (Permiso p : lstPermiso) {
				Hibernate.initialize(p.getDesdeHasta());
				if (p instanceof PermisoPeriodo) {
					PermisoPeriodo permiso = (PermisoPeriodo) p;
					Hibernate.initialize(permiso.getRodado());
					PermisoPeriodoModel retorno = permisoPeriodoModel.entityToModel(permiso);
					Iterator<Lugar> it = p.getDesdeHasta().iterator();
					while (it.hasNext()) {
						retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
					}
					if (p.activo(p, LocalDate.parse(fecha.getFechaHasta(), formatter))
							&& p.getDesdeHasta().contains(lOrigen) && p.getDesdeHasta().contains(lDestino)) {
						permisos.add(retorno);
					}
				}

				if (p instanceof PermisoDiario) {
					PermisoDiario permiso = (PermisoDiario) p;
					PermisoDiarioModel retorno = permisoDiarioModel.entityToModel(permiso);
					Iterator<Lugar> it = p.getDesdeHasta().iterator();
					while (it.hasNext()) {
						retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
					}
					if (p.activo(p, LocalDate.parse(fecha.getFechaHasta(), formatter))
							&& p.getDesdeHasta().contains(lugarModel.modelToEntity(fecha.getLugarOrigenModel()))
							&& p.getDesdeHasta().contains(lugarModel.modelToEntity(fecha.getLugarDestinoModel()))) {
						permisos.add(retorno);
					}

				}

			}

			return permisos;

		} catch (Exception e) {
			throw new Exception("No se ha encontrado resultados");
		}

	}
}
