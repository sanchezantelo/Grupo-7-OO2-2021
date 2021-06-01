package com.webservice.app.services.implementation;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public List<Lugar>  traerTodos(){
		List<Lugar>lugares=new ArrayList<Lugar>();
		lugares.add(new Lugar());
	    Iterator<Lugar> it=lugarRepository.findAll().iterator();
	    while(it.hasNext()) {
	    	lugares.add(it.next());
	    }
		return lugares;
		
	}
	
	public Lugar findById(int idLugar){
		return lugarRepository.findByIdLugar(idLugar);
	}

}