package com.webservice.app.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.webservice.app.entities.PermisoDiario;
import com.webservice.app.models.PermisoDiarioModel;

@Component("permisoDiarioModel")

public class PermisoDiarioConverter {
	
	@Autowired
	@Qualifier("personaModel")
	private PersonaConverter personaModel;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


	public PermisoDiarioModel entityToModel(PermisoDiario permisoDiario) {
		
		return new PermisoDiarioModel(permisoDiario.getIdPermiso(),personaModel.entityToModel(permisoDiario.getPersona()),permisoDiario.getFecha().format(formatter),permisoDiario.getMotivo());
	}

	public PermisoDiario modelToEntity(PermisoDiarioModel permisoDiarioModel) {
		return new PermisoDiario(permisoDiarioModel.getIdPermiso(), personaModel.modelToEntity(permisoDiarioModel.getPersona()),
				LocalDate.parse(permisoDiarioModel.getFecha(), formatter), permisoDiarioModel.getMotivo());
	}
}
