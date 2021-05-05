package com.webservice.app.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*
@Entity
@Table(name="usuario")*/
public class Usuario {
	
	//FALTA
	//Vincular atributos con la base de datos+atributos que faltan
	
	private int idUsuario;
	private String nombre;
	private String apellido;
	private long dni;
	private String email;
	private String nombreUsuario;
	private String password;
	private boolean enabled;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<Rol> roles = new HashSet<Rol>();

	public Usuario() {}
	
	
	
	public Usuario(String nombre, String apellido, long dni, String email, String nombreUsuario, String password,
			boolean enabled) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.enabled = enabled;
	}



	public Usuario(String nombre, String apellido, long dni, String email, String nombreUsuario, String password,
			boolean enabled, Set<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public long getDni() {
		return dni;
	}



	public void setDni(long dni) {
		this.dni = dni;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public Set<Rol> getUserRoles() {
		return roles;
	}

	public void setUserRoles(Set<Rol> roles) {
		this.roles = roles;
	}

}
