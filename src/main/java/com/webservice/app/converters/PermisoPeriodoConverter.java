package com.webservice.app.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.webservice.app.entities.PermisoPeriodo;
import com.webservice.app.models.PermisoPeriodoModel;

@Component("permisoPeriodoModel")

public class PermisoPeriodoConverter {
	
	@Autowired
	@Qualifier("personaModel")
	private PersonaConverter personaModel;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	@Qualifier("rodadoModel")
	private RodadoConverter rodadoModel;

	public PermisoPeriodoModel entityToModel(PermisoPeriodo permisoPeriodo) {
		return new PermisoPeriodoModel(permisoPeriodo.getIdPermiso(), personaModel.entityToModel(permisoPeriodo.getPersona()),
				permisoPeriodo.getFecha().format(formatter), permisoPeriodo.getCantDias(),
				permisoPeriodo.isVacaciones(), rodadoModel.entityToModel(permisoPeriodo.getRodado()));
	}

	public PermisoPeriodo modelToEntity(PermisoPeriodoModel permisoPeriodoModel) {
		return new PermisoPeriodo(permisoPeriodoModel.getIdPermiso(), personaModel.modelToEntity(permisoPeriodoModel.getPersona()),
				LocalDate.parse(permisoPeriodoModel.getFecha(), formatter), permisoPeriodoModel.getCantDias(),
				permisoPeriodoModel.isVacaciones(), rodadoModel.modelToEntity(permisoPeriodoModel.getRodado()));
	}
}
