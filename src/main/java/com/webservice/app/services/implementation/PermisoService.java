package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.LugarConverter;
import com.webservice.app.converters.PermisoDiarioConverter;
import com.webservice.app.converters.PermisoPeriodoConverter;
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
	@Qualifier("permisoPeriodoModel")
	private PermisoPeriodoConverter permisoPeriodoModel;

	public Permiso findByIdPermiso(int idPermiso) {
		return permisoRepository.findByIdPermiso(idPermiso);
	}

	// ALTA

	public void altaPermiso(PermisoModel permisoModel,LugarModel lugarOrigenModel, LugarModel lugarDestinoModel) throws Exception {
		try {
			if (permisoModel instanceof PermisoDiarioModel) {
				Permiso permiso = permisoDiarioModel.modelToEntity((PermisoDiarioModel) permisoModel);
				//permiso.getDesdeHasta().add(lugarModel.modelToEntity(lugarOrigenModel));
				permiso.getDesdeHasta().add(lugarModel.modelToEntity(lugarDestinoModel));
				permisoRepository.save(permiso);
			}
			if (permisoModel instanceof PermisoPeriodoModel) {
				Permiso permiso = permisoPeriodoModel.modelToEntity((PermisoPeriodoModel) permisoModel);
				permisoRepository.save(permiso);
			}
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación,error al ingresar los datos o el permiso ya existe");
		}
	}
}