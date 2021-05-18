package com.webservice.app.models;

public class PersonaModel {
	private int id;
	private String nombre;
	private String apellido;
	private Long dni;
	private String email;

	public PersonaModel() {
		super();
	}

	public PersonaModel(int id, String nombre, String apellido, Long dni, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}

	public PersonaModel(String nombre, String apellido, Long dni, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonaModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email="
				+ email + "]";
	}

}
