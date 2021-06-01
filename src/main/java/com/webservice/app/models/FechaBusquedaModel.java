package com.webservice.app.models;

import org.springframework.format.annotation.DateTimeFormat;

public class FechaBusquedaModel {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaDesde;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaHasta;
	private LugarModel lugarOrigenModel;
	private LugarModel lugarDestinoModel;

	public FechaBusquedaModel() {
	}

	public FechaBusquedaModel(String fechaDesde, String fechaHasta) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public FechaBusquedaModel(String fechaDesde, String fechaHasta, LugarModel lugarOrigenModel,
			LugarModel lugarDestinoModel) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.lugarOrigenModel = lugarOrigenModel;
		this.lugarDestinoModel = lugarDestinoModel;
	}

	public FechaBusquedaModel(LugarModel lugarOrigenModel, LugarModel lugarDestinoModel) {
		super();
		this.lugarOrigenModel = lugarOrigenModel;
		this.lugarDestinoModel = lugarDestinoModel;
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

	@Override
	public String toString() {
		return "FechaBusquedaModel [fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", lugarOrigenModel="
				+ lugarOrigenModel + ", lugarDestinoModel=" + lugarDestinoModel + "]";
	}

}
