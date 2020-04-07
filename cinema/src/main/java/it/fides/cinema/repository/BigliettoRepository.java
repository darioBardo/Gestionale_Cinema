package it.fides.cinema.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Biglietto;

@Repository
public interface BigliettoRepository extends CrudRepository<Biglietto, Long> {

	@Query(value = "select count(*) from biglietto where id_proiezione = :numProiezione", nativeQuery = true)
	public Long bigliettiAcquistati(@Param("numProiezione") Long numProiezione);
	
	
}
