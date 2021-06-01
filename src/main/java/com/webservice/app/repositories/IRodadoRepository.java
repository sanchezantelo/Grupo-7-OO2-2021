package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webservice.app.entities.Rodado;

@Repository("rodadoRepository")
public interface IRodadoRepository extends JpaRepository<Rodado, Serializable> {

	public abstract Rodado findByIdRodado(@Param("idRodado") int idRodado);

	@Query("SELECT r FROM Rodado r WHERE (r.dominio LIKE :dominio)")
	public abstract Rodado findByDominioVehiculo(@Param("dominio") String dominio);

}
