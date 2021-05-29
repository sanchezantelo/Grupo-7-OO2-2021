package com.webservice.app.models;

import java.util.HashSet;
import java.util.Set;

public abstract class PermisoModel {
	protected int idPermiso;
	protected PersonaModel persona;
	protected String fecha;
	protected Set<LugarModel> desdeHasta = new HashSet<LugarModel>();

	public PermisoModel() {
	}

	public PermisoModel(int idPermiso, PersonaModel persona, String fecha) {
		super();
		this.idPermiso = idPermiso;
		this.persona = persona;
		this.fecha = fecha;
	}

	public PermisoModel(PersonaModel persona, String fecha) {
		super();
		this.persona = persona;
		this.fecha = fecha;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", persona=" + persona + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + "]";
	}

}
