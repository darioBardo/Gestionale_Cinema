package it.fides.cinema.service;

import java.util.List;

import it.fides.cinema.dto.SalaDto;

public interface GestioneSala {

	public List<SalaDto> showSala();
	
	public boolean insertSala(String nomeSala, Long numeroPosti);
	
	public void deleteSala(Long	id);
	
}
