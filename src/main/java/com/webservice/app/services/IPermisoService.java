package com.webservice.app.services;

import com.webservice.app.entities.Permiso;
import com.webservice.app.models.LugarModel;
import com.webservice.app.models.PermisoModel;

public interface IPermisoService {

	Permiso findByIdPermiso(int idPermiso);

	void altaPermiso(PermisoModel permisoModel, LugarModel lugarOrigenModel, LugarModel lugarDestinoModel) throws Exception;

}
