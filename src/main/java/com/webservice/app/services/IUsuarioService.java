package com.webservice.app.services;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.PersonaModel;
import com.webservice.app.models.UsuarioModel;

public interface IUsuarioService {

	Usuario findByUsuario(String usuarioModel);

	Usuario findById(int id);

	void altaUsuario(UsuarioModel usuarioModel);

	void bajaUsuario(UsuarioModel usuarioModel);

	void modificacionUsuario(UsuarioModel usuarioModel);

}
