package it.fides.cinema.service;

import java.util.List;

import it.fides.cinema.dto.FilmDto;

public interface GestioneFilm {
	
	public boolean insertFilm(FilmDto film);

	public List<FilmDto> showFilm();

	public void deleteFilm(Long id);

}
