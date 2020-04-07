package it.fides.cinema.service;

import java.util.List;
import java.util.Set;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.SalaDto;

public interface GestionePosto {
	
	public List<PostoDto> showPosti(Long id);
	
	public Set<PostoDto> generatePosti(SalaDto sala);
	
	
}
