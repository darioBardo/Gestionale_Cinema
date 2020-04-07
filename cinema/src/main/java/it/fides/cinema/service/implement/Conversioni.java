package it.fides.cinema.service.implement;

import java.util.HashSet;
import java.util.Set;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.entity.Posto;
import it.fides.cinema.entity.Sala;

public class Conversioni {

	public SalaDto convertToSalaDto(Sala sala) {
		SalaDto salaDto = new SalaDto();
		Set<PostoDto> setPosti = new HashSet<>();
		salaDto.setId(sala.getId());
		salaDto.setNomeSala(sala.getNomeSala());
		salaDto.setNumeroPosti(sala.getNumeroPosti());
		for (Posto posto : sala.getPostiSet()) {
			PostoDto dto = new PostoDto();
			dto = convertToPostoDto(posto);
			setPosti.add(dto);
		}
		salaDto.setPostiSet(setPosti);
		//salaDto.setProiezione(sala.getProiezione()); //Da Fare proiezione -> proiezioneDto
		return salaDto;
	}
	
	public Sala convertToSala(SalaDto salaDto) {
		Sala sala = new Sala();
		Set<Posto> setPosti = new HashSet<>();
		sala.setId(salaDto.getId());
		sala.setNomeSala(salaDto.getNomeSala());
		sala.setNumeroPosti(salaDto.getNumeroPosti());
		for (PostoDto dto : salaDto.getPostiSet()) {
			Posto posto = new Posto();
			posto = convertToPosto(dto);
			setPosti.add(posto);
		}
		sala.setPostiSet(setPosti); //Da fare posto -> postoDto
		//sala.setProiezione(salaDto.getProiezione()); //Da Fare proiezione -> proiezioneDto
		return sala;
	}
	
	public PostoDto convertToPostoDto(Posto posto) {
		PostoDto dto = new PostoDto();
		
		dto.setId(posto.getId());
		dto.setFila(posto.getFila());
		dto.setNumero(posto.getNumero());
		dto.setSala(convertToSalaDto(posto.getSala()));
		
		return dto;
	}
	
	public Posto convertToPosto(PostoDto dto) {
		Posto posto = new Posto();
		
		posto.setId(dto.getId());
		posto.setFila(dto.getFila());
		posto.setNumero(dto.getNumero());
		posto.setSala(convertToSala(dto.getSala()));
		
		return posto;
	}
	
}
