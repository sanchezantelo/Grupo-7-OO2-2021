package com.webservice.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.UsuarioRolConverter;
import com.webservice.app.entities.UsuarioRol;
import com.webservice.app.models.UsuarioRolModel;
import com.webservice.app.repositories.IUsuarioRolRepository;
import com.webservice.app.services.IUsuarioRolService;

@Service("usuarioRolService")
public class UsuarioRolService implements IUsuarioRolService {

	@Autowired
	@Qualifier("usuarioRolRepository")
	private IUsuarioRolRepository usuarioRolRepository;

	@Autowired
	@Qualifier("usuarioRolModel")
	private UsuarioRolConverter usuarioRolModel;


	public UsuarioRol findByUsuarioRol(String usuarioRol) {
		return usuarioRolRepository.findByRol(usuarioRol);
	}

	public UsuarioRol findById(int id) {
		return usuarioRolRepository.findById(id);
	}
	public UsuarioRolModel traerUsuarioRol(int id) {
		
		return usuarioRolModel.entityToModel(usuarioRolRepository.findById(id));
	}

	public void altaUsuarioRol(UsuarioRolModel usuarioRol) {
		UsuarioRol rol = usuarioRolModel.modelToEntity(usuarioRol);
		usuarioRolRepository.save(rol);
	}

	public void bajaUsuarioRol(int id) {
		usuarioRolRepository.deleteById(id);
	}

	public void modificacionUsuarioRol(UsuarioRolModel usuarioRol) {
		usuarioRolRepository.saveAndFlush(usuarioRolModel.modelToEntity(usuarioRol));
	}

	public List<UsuarioRol> findAll() {

		return usuarioRolRepository.findAll();
	}
}
