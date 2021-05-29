package com.webservice.app.models;

import java.time.LocalDate;

public class PermisoDiarioModel extends PermisoModel {
	private String motivo;

	public PermisoDiarioModel(String motivo) {
		super();
		this.motivo = motivo;
	}

	public PermisoDiarioModel() {
		super();
	}

	public PermisoDiarioModel(int idPermiso, PersonaModel persona, String fecha, String motivo) {
		super(idPermiso, persona, fecha);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiarioModel [motivo=" + motivo + "]";
	}

}
