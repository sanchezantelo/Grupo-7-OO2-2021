package com.webservice.app.services.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public UsuarioModel traerUsuario(int id) {

		return usuarioModel.entityToModel(usuarioRepository.findById(id));
	}

	public void altaUsuario(UsuarioModel usuario) throws Exception {
		try {
			Usuario user = usuarioModel.modelToEntity(usuario);
			usuarioRepository.save(user);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
		}
	}

	public void bajaUsuario(int id) throws Exception {
		Usuario usuario = usuarioRepository.findById(id);
		usuario.setEnabled(false);
		try {
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public void modificacionUsuario(UsuarioModel usuario) throws Exception {
		try {
			usuarioRepository.saveAndFlush(usuarioModel.modelToEntity(usuario));
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public List<Usuario> findAll() {

		return usuarioRepository.findByEnabled();
	}
	
	
	
    //METODO PARA MOSTRAR UNA LISTA DE ELEMENTOS CON PAGINACION 
			
	 public Page<Usuario> findPaginated(Pageable pageable) {
	        int pageSize = pageable.getPageSize();
	        int currentPage = pageable.getPageNumber();
	        int startItem = currentPage * pageSize;
	        List<Usuario> lstUsuarios= new ArrayList<Usuario>();

	        if (lstUsuarios.size() < startItem) {
	        	lstUsuarios = Collections.emptyList();
	        } else {
	            int toIndex = Math.min(startItem + pageSize, lstUsuarios.size());
	            lstUsuarios = lstUsuarios.subList(startItem, toIndex);
	        }

	        Page<Usuario> userPage
	          = new PageImpl<Usuario>(lstUsuarios, PageRequest.of(currentPage, pageSize), lstUsuarios.size());

	        return userPage;
	    }
}
