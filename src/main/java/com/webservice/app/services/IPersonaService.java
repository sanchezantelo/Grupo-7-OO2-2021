package com.webservice.app.services;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.PersonaModel;

public interface IPersonaService {

	Usuario findByUsuario(String usuarioModel);

	Usuario findById(int id);

}
