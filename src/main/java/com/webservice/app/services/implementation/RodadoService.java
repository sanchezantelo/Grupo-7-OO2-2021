package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Rodado;

import com.webservice.app.models.RodadoModel;

import com.webservice.app.repositories.IRodadoRepository;

import com.webservice.app.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService {

	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	public Rodado findByDominioVehiculo(RodadoModel rodadoModel) {
		return rodadoRepository.findByDominioVehiculo(rodadoModel.getDominio(), rodadoModel.getVehiculo());
	}

}