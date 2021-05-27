package com.webservice.app.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
@Inheritance(strategy = InheritanceType.JOINED) 
public abstract class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	protected Persona persona;
    
	@Column(name = "fecha", nullable = false)
	protected LocalDate fecha;

	@ManyToMany
	protected Set<Lugar>desdeHasta;

	public Permiso() {
		super();
	}

	public Permiso(int idPermiso, Persona persona, LocalDate fecha, Set<Lugar> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
		this.persona = persona;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

}
