package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.Permiso;
import com.webservice.app.models.PermisoModel;

public interface IPermisoService {

	Permiso findByIdPermiso(int idPermiso);

	void altaPermiso(PermisoModel permisoModel) throws Exception;
	
	List<Permiso> findByPersona(long dni);

}
