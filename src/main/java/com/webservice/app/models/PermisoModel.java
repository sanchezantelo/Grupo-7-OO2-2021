package com.webservice.app.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public abstract class PermisoModel {
	protected int idPermiso;
	@NotNull
    @Valid
	protected PersonaModel persona;
	protected String fecha;
	protected Set<LugarModel> desdeHasta = new HashSet<LugarModel>();
	protected LugarModel lugarOrigenModel;
	protected LugarModel lugarDestinoModel;

	public PermisoModel() {
	}

	public PermisoModel(int idPermiso, PersonaModel persona, String fecha, LugarModel lugarOrigenModel,
			LugarModel lugarDestinoModel) {
		super();
		this.idPermiso = idPermiso;
		this.persona = persona;
		this.fecha = fecha;
		this.lugarOrigenModel = lugarOrigenModel;
		this.lugarDestinoModel = lugarDestinoModel;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public LugarModel getLugarOrigenModel() {
		return lugarOrigenModel;
	}

	public void setLugarOrigenModel(LugarModel lugarOrigenModel) {
		this.lugarOrigenModel = lugarOrigenModel;
	}

	public LugarModel getLugarDestinoModel() {
		return lugarDestinoModel;
	}

	public void setLugarDestinoModel(LugarModel lugarDestinoModel) {
		this.lugarDestinoModel = lugarDestinoModel;
	}

	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", persona=" + persona + ", fecha=" + fecha
				+ ", lugarOrigenModel=" + lugarOrigenModel + ", lugarDestinoModel=" + lugarDestinoModel + "]";
	}
	
	public abstract String infAdicional();
}
