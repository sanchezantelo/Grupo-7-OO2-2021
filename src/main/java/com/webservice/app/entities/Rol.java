package com.webservice.app.entities;

import java.time.LocalDateTime;


public class Rol {
	
	//Hay que vincular los atributos con la columna de la base de datos correspondiente.
	
	private int idRol;
	private Usuario usuario;
	private String rol;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Rol() {}
	
	public Rol(int idRol, Usuario usuario, String rol) {
		this.idRol = idRol;
		this.usuario = usuario;
		this.rol = rol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
