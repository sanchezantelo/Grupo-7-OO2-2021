package com.webservice.app.converters;

import org.springframework.stereotype.Component;
import com.webservice.app.entities.Rodado;
import com.webservice.app.models.RodadoModel;

@Component("rodadoModel")

public class RodadoConverter {

	public RodadoModel entityToModel(Rodado rodado) {
		return new RodadoModel(rodado.getIdRodado(), rodado.getDominio(), rodado.getVehiculo());
	}

	public Rodado modelToEntity(RodadoModel rodadoModel) {
		return new Rodado(rodadoModel.getIdRodado(), rodadoModel.getDominio(), rodadoModel.getVehiculo());
	}
}
