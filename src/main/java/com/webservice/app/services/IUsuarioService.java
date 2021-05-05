package com.webservice.app.services;
import java.util.List;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;


public interface IUsuarioService {

	public List<Usuario> getAll();
	
	public UsuarioModel findById(int idUsuario);
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	
	public boolean remove(int idUsuario);
	
	
}

