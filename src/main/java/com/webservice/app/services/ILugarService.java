package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.Lugar;

public interface ILugarService {
	 
	List<Lugar>  findAll();
	
	List<Lugar>  traerTodos();
	
	Lugar findById(int idLugar);

}
