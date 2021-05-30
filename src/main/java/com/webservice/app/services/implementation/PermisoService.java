package com.webservice.app.services.implementation;

import java.util.Iterator;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.LugarConverter;
import com.webservice.app.converters.PermisoDiarioConverter;
import com.webservice.app.converters.PermisoPeriodoConverter;
import com.webservice.app.converters.RodadoConverter;
import com.webservice.app.entities.Lugar;
import com.webservice.app.entities.Permiso;
import com.webservice.app.entities.PermisoDiario;
import com.webservice.app.entities.PermisoPeriodo;
import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.models.RodadoModel;
import com.webservice.app.repositories.IPermisoPeriodoRepository;
import com.webservice.app.repositories.IPermisoRepository;
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
	@Qualifier("lugarService")
	private LugarService lugarService;

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService personaService;

	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;

	public Permiso findByIdPermiso(int idPermiso) {
		return permisoRepository.findByIdPermiso(idPermiso);
	}

	// ALTA PERMISO

	public void altaPermiso(PermisoModel permisoModel) throws Exception {
		try {

			if (permisoModel instanceof PermisoDiarioModel) {
				Permiso permiso = permisoDiarioModel.modelToEntity((PermisoDiarioModel) permisoModel);
				permiso.getDesdeHasta().add(lugarService.findById(permisoModel.getLugarOrigenModel().getIdLugar()));
				permiso.getDesdeHasta().add(lugarService.findById(permisoModel.getLugarDestinoModel().getIdLugar()));
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

	// TRAER PERMISO POR PERSONA

	public PermisoPeriodoModel findByPersonaPeriodo(long dni) {
		PermisoPeriodo permiso = (PermisoPeriodo) permisoRepository.findByPersona(personaService.findByDni(dni));
		Hibernate.initialize(permiso.getRodado());
		PermisoPeriodoModel retorno = permisoPeriodoModel.entityToModel(permiso);
		Iterator<Lugar> it = permiso.getDesdeHasta().iterator();
		while (it.hasNext()) {
			retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
		}
		return retorno;
	}

	public PermisoDiarioModel findByPersonaDiario(long dni) {
		PermisoDiario permiso = (PermisoDiario) permisoRepository.findByPersona(personaService.findByDni(dni));
		PermisoDiarioModel retorno = permisoDiarioModel.entityToModel(permiso);
		Iterator<Lugar> it = permiso.getDesdeHasta().iterator();
		while (it.hasNext()) {
			retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
		}
		return retorno;
	}

	public PermisoPeriodoModel findByRodado(RodadoModel rodadoModel) {
		PermisoPeriodo permiso = (PermisoPeriodo) permisoPeriodoRepository
				.findByRodado(rodadoService.findByDominioVehiculo(rodadoModel));
		Hibernate.initialize(permiso.getRodado());
		PermisoPeriodoModel retorno = permisoPeriodoModel.entityToModel(permiso);
		Iterator<Lugar> it = permiso.getDesdeHasta().iterator();
		while (it.hasNext()) {
			retorno.getDesdeHasta().add(lugarModel.entityToModel(it.next()));
		}
		return retorno;
	}

}