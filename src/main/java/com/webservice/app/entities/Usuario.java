package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "usuario", unique = true, nullable = false, length = 45)
	private String usuario;

	@Column(name = "clave", nullable = false, length = 60)
	private String clave;

	@OneToOne(mappedBy = "usuario")
	private Persona persona;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<UsuarioRol> usuarioRoles = new HashSet<UsuarioRol>();

	public Usuario() {
	}

	public Usuario(String usuario, String clave, boolean enabled) {
		this.usuario = usuario;
		this.clave = clave;
		this.enabled = enabled;
	}

	public Usuario(String usuario, String clave, boolean enabled, Set<UsuarioRol> usuarioRoles, Persona persona) {
		this.usuario = usuario;
		this.clave = clave;
		this.enabled = enabled;
		this.usuarioRoles = usuarioRoles;
		this.persona = persona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	public String getclave() {
		return clave;
	}

	public void setclave(String clave) {
		this.clave = clave;
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

	public Set<UsuarioRol> getusuarioRoles() {
		return usuarioRoles;
	}

	public void setusuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}