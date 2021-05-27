package com.webservice.app.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PermisoDiario extends Permiso {

	@Column(name = "motivo", nullable = false, length = 45)
	private String motivo;

	public PermisoDiario() {
		super();
	}

	public PermisoDiario(String motivo) {
		super();
		this.motivo = motivo;
	}

	public PermisoDiario(int idPermiso, Persona persona, LocalDate fecha, Set<Lugar> desdeHasta, String motivo) {
		super(idPermiso, persona, fecha, desdeHasta);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
