package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.Permiso;
import com.webservice.app.models.FechaBusquedaModel;
import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.models.RodadoModel;

public interface IPermisoService {

	Permiso findByIdPermiso(int idPermiso);

	void altaPermiso(PermisoModel permisoModel) throws Exception;

	PermisoPeriodoModel findByPersonaPeriodo(long dni);

	PermisoPeriodoModel findByRodado(RodadoModel rodadoModel);

	PermisoDiarioModel findByPersonaDiario(long dni);

	public List<PermisoModel> findByActivoPermiso(FechaBusquedaModel fecha);

}
