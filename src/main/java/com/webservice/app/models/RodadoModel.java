package com.webservice.app.models;

import javax.validation.constraints.Size;

public class RodadoModel {

	private int idRodado;
	@Size(max = 6 ,message="No se puede ingresar mas de 6 caracteres")
	private String dominio;
	private String vehiculo;

	public RodadoModel() {
	}

	public RodadoModel(int idRodado, String dominio, String vehiculo) {
		super();
		this.idRodado = idRodado;
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public RodadoModel(String dominio, String vehiculo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "dominio=" + dominio + ", vehiculo=" + vehiculo + "";
	}

}
