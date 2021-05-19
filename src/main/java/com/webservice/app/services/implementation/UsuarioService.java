package com.webservice.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.PersonaConverter;
import com.webservice.app.converters.UsuarioConverter;
import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.repositories.IUsuarioRepository;
import com.webservice.app.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioModel")
	private UsuarioConverter usuarioModel;

	@Autowired
	@Qualifier("personaModel")
	private PersonaConverter personaModel;

	public Usuario findByUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
	}

	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}

	public void altaUsuario(UsuarioModel usuario) {
		Usuario user = usuarioModel.modelToEntity(usuario);
		// user.setPersona(personaModel.modelToEntity(persona));
		usuarioRepository.save(user);
	}

	public void bajaUsuario(int id) {
		usuarioRepository.deleteById(id);
	}

	public void modificacionUsuario(UsuarioModel usuario) {
		usuarioRepository.saveAndFlush(usuarioModel.modelToEntity(usuario));
	}

	public List<Usuario> findAll() {

		return usuarioRepository.findAll();
	}
}
