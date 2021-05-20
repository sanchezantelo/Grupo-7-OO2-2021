package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.UsuarioRol;
import com.webservice.app.models.UsuarioRolModel;

public interface IUsuarioRolService {

	UsuarioRol findByUsuarioRol(String usuarioRol);

	UsuarioRol findById(int id);
	
	List<UsuarioRol> findAll();
	
	UsuarioRolModel traerUsuarioRol(int id);

	void altaUsuarioRol(UsuarioRolModel usuarioRol);

	void bajaUsuarioRol(int id);

	void modificacionUsuarioRol(UsuarioRolModel usuarioRol);

}
