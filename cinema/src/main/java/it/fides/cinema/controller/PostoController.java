package it.fides.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.service.GestionePosto;

@CrossOrigin
@RestController
public class PostoController {
	@Autowired
	private GestionePosto crudPosto;
	
	@GetMapping(value = "/listaPosti")
	public List<PostoDto> mostraPosti(@RequestParam Long id){
		return crudPosto.showPosti(id); 
	}
	
	

}