package com.webservice.app.services;


import com.webservice.app.entities.Usuario;

public interface IUsuarioService {
	
	 Usuario findByUsuario(String usuario);
	 
	 Usuario findById(int id);
	 
	 void altaUsuario(Usuario usuario);
	 void bajaUsuario(Usuario usuario);
	 void modificacionUsuario(Usuario usuario);

}
