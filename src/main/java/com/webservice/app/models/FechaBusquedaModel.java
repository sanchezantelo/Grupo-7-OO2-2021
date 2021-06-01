package com.webservice.app.models;

import org.springframework.format.annotation.DateTimeFormat;

public class FechaBusquedaModel {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaDesde;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaHasta;

	public FechaBusquedaModel() {
	}

	public FechaBusquedaModel(String fechaDesde, String fechaHasta) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	@Override
	public String toString() {
		return "FechaBusqueda [fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + "]";
	}

}
