package com.webservice.app.models;

public class UsuarioRolModel {
	private int id;
	private String rol;

	public UsuarioRolModel(int id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public UsuarioRolModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioRolModel [id=" + id + ", rol=" + rol + "]";
	}

}
