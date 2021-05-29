package com.webservice.app.converters;

import org.springframework.stereotype.Component;

import com.webservice.app.entities.Lugar;
import com.webservice.app.models.LugarModel;

@Component("lugarModel")

public class LugarConverter {

	public LugarModel entityToModel(Lugar lugar) {
		return new LugarModel(lugar.getIdLugar(), lugar.getLugar(),lugar.getCodigoPostal());
	}

	public Lugar modelToEntity(LugarModel lugarModel) {
		return new Lugar(lugarModel.getIdLugar(), lugarModel.getLugar(),lugarModel.getCodigoPostal());
	}
}

