package com.webservice.app.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Permiso;
import com.webservice.app.entities.Persona;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable> {

	public abstract Permiso findByIdPermiso(@Param("idPermiso") int idPermiso);

	public abstract Permiso findByPersona(@Param("persona") Persona persona);
	
	@Query("SELECT p FROM Permiso p JOIN FETCH p.persona JOIN FETCH p.desdeHasta WHERE p.fecha between :fechaDesde AND :fechaHasta")
	public abstract List<Permiso> findByActivoPermiso(@Param("fechaDesde") LocalDate fechaDesde, @Param("fechaHasta") LocalDate fechaHasta);

}
