package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;

public interface IUsuarioService {

	Usuario findByUsuario(String usuarioModel);

	Usuario findById(int id);
	
	UsuarioModel traerUsuario(int id);
	
	List<Usuario>findAll();

	void altaUsuario(UsuarioModel usuarioModel);

	void bajaUsuario(int id);

	void modificacionUsuario(UsuarioModel usuarioModel);

}
