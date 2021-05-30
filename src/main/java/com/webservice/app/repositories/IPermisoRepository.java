package com.webservice.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Permiso;
import com.webservice.app.entities.Persona;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Serializable> {

	public abstract Permiso findByIdPermiso(@Param("idPermiso") int idPermiso);
	
	public abstract List<Permiso> findByPersona(@Param("persona") Persona persona);

}
