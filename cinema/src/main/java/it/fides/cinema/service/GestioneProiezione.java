package it.fides.cinema.service;

import java.util.List;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.ProiezioneDto;

public interface GestioneProiezione {
	
	public List<ProiezioneDto> showProiezioni();
	
	public boolean insertProiezione(ProiezioneDto nuovaProiezione);
	
	public void deleteProiezione(ProiezioneDto oldProiezione);
	
	public List<PostoDto> mostraPostiDisponibili(Long idProiezione);
	
	public Long contaPostiDisponibili(Long idProiezione);
}
