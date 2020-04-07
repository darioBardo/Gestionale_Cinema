package it.fides.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.service.GestioneFilm;

@CrossOrigin
@RestController
public class FilmController {

	@Autowired
	private GestioneFilm gestioneFilm;
	
	
	@PostMapping(value = "/insertFilm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String inserisciFilm(FilmDto film) {
		if(gestioneFilm.insertFilm(film)) {			
			return "Film inserito correttamente";
		}
		return "Errore";
	}
	
	@GetMapping(value = "/mostraFilm")
	public List<FilmDto> mostraFilm(){
		return gestioneFilm.showFilm();
	}
	
	@PostMapping(value = "eliminaFilm")
	public String deleteFilm(@RequestParam Long id){
		
		gestioneFilm.deleteFilm(id);
		
		return "Film eliminato correttamente";
		
	}
}
