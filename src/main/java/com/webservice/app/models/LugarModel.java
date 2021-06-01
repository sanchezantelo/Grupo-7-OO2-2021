package com.webservice.app.models;

public class LugarModel {
	private int idLugar;
	private String lugar;
	private String codigoPostal;

	public LugarModel() {
	}

	public LugarModel(int idLugar, String lugar, String codigoPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public LugarModel(String lugar, String codigoPostal) {
		super();
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "LugarModel [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + "]";
	}

	public String lugar() {
		return lugar + "," + codigoPostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLugar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LugarModel other = (LugarModel) obj;
		if (idLugar != other.idLugar)
			return false;
		return true;
	}
	
	
	
}
