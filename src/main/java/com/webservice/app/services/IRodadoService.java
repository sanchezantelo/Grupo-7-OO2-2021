package com.webservice.app.services;

import com.webservice.app.entities.Rodado;
import com.webservice.app.models.RodadoModel;

public interface IRodadoService {

	Rodado findByDominioVehiculo(RodadoModel rodadoModel);

}
