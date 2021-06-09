package com.webservice.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PermisoPeriodoModel extends PermisoModel {
	private int cantDias;
	private boolean vacaciones;
	@NotNull
    @Valid
	private RodadoModel rodado;

	public PermisoPeriodoModel() {
		super();
	}

	public PermisoPeriodoModel(int cantDias, boolean vacaciones, RodadoModel rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public PermisoPeriodoModel(int idPermiso, PersonaModel persona, String fecha, int cantDias, boolean vacaciones,
			RodadoModel rodado) {
		super(idPermiso, persona, fecha);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public RodadoModel getRodado() {
		return rodado;
	}

	public void setRodado(RodadoModel rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodoModel [cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado=" + rodado + "]";
	}

	public String infAdicional() {
		return "Cantidad de dias=" + cantDias + ", Vacaciones=" + vacaciones + ", Rodado=" + rodado + "";
	}
}
