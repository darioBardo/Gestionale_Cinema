package it.fides.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Sala;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long>{
	
	List<Sala> findByOrderByIdAsc();
	
}
