package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Usuario;
import com.webservice.app.repositories.IUsuarioRepository;
import com.webservice.app.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	public Usuario findByUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
	}

	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}

	public void altaUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void bajaUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public void modificacionUsuario(Usuario usuario) {
		usuarioRepository.saveAndFlush(usuario);
	}

}
