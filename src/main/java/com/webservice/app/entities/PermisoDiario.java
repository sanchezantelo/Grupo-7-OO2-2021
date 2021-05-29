package com.webservice.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PermisoDiario extends Permiso {

	@Column(name = "motivo", nullable = false, length = 45)
	private String motivo;

	public PermisoDiario() {
		super();
	}

	public PermisoDiario(int idPermiso, Persona persona, LocalDate fecha, String motivo) {
		super(idPermiso, persona, fecha);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
