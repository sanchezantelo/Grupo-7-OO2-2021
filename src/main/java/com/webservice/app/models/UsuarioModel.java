package com.webservice.app.models;

import com.webservice.app.entities.Persona;

public class UsuarioModel {
	private int id;
	private String usuario;
	private String clave;
	private Persona persona;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int id, String usuario, String clave, Persona persona) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
		this.persona = persona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", persona=" + persona + "]";
	}

}
