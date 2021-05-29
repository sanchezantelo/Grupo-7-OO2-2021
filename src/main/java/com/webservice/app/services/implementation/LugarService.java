package com.webservice.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Lugar;
import com.webservice.app.repositories.ILugarRepository;
import com.webservice.app.services.ILugarService;


@Service("lugarService")
public class LugarService implements ILugarService {

	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;


	public List<Lugar> findAll() {
		return lugarRepository.findAll();
	}

}