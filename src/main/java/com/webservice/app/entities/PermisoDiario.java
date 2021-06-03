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

	@Override
	public boolean activo(Permiso permiso, LocalDate dia) {
		boolean habilitado = true;
		LocalDate diaInicio = permiso.getFecha();
		LocalDate diaHasta = permiso.getFecha().plusDays(1);
		if (permiso.getDesdeHasta().contains(this)) {
			if (diaInicio.equals(dia) || diaHasta.equals(dia)) {
				habilitado = true;
			} else if (dia.isAfter(diaInicio) && dia.isBefore(diaHasta)) {
				habilitado = true;
			}
		}
		return habilitado;
	}

}
