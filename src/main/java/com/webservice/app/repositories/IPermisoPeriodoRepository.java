package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Permiso;
import com.webservice.app.entities.PermisoPeriodo;
import com.webservice.app.entities.Rodado;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable> {

	public abstract Permiso findByRodado(@Param("rodado") Rodado rodado);
}
