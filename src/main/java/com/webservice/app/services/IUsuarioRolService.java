package com.webservice.app.services;

import com.webservice.app.entities.UsuarioRol;

public interface IUsuarioRolService {

	UsuarioRol findByUsuarioRol(String usuarioRol);

	UsuarioRol findById(int id);

	void altaUsuarioRol(UsuarioRol usuarioRol);

	void bajaUsuarioRol(UsuarioRol usuarioRol);

	void modificacionUsuarioRol(UsuarioRol usuarioRol);

}
