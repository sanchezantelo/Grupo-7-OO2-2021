package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Set;

import com.webservice.app.entities.Lugar;
import com.webservice.app.entities.Persona;

public abstract class PermisoModel {
	protected int idPermiso;
	protected Persona persona;
	protected LocalDate fecha;
	protected Set<Lugar> desdeHasta;

	public PermisoModel() {
	}

	public PermisoModel(Persona persona, LocalDate fecha, Set<Lugar> desdeHasta) {
		super();
		this.persona = persona;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}
	
	

	public PermisoModel(int idPermiso, Persona persona, LocalDate fecha, Set<Lugar> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
		this.persona = persona;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", persona=" + persona + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + "]";
	}

}
