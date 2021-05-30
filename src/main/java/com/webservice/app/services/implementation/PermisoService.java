package com.webservice.app.services.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.LugarConverter;
import com.webservice.app.converters.PermisoDiarioConverter;
import com.webservice.app.converters.PermisoPeriodoConverter;
import com.webservice.app.entities.Lugar;
import com.webservice.app.entities.Permiso;
import com.webservice.app.models.LugarModel;
import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.repositories.IPermisoRepository;
import com.webservice.app.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {

	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

	@Autowired
	@Qualifier("permisoDiarioModel")
	private PermisoDiarioConverter permisoDiarioModel;
	
	@Autowired
	@Qualifier("lugarModel")
	private LugarConverter lugarModel;

	@Autowired
	@Qualifier("lugarService")
	private LugarService lugarService;

	@Autowired
	@Qualifier("permisoPeriodoModel")
	private PermisoPeriodoConverter permisoPeriodoModel;

	public Permiso findByIdPermiso(int idPermiso) {
		return permisoRepository.findByIdPermiso(idPermiso);
	}

	// ALTA

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
}