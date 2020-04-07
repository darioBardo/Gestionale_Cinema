package it.fides.cinema.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.enumeration.RoleEnum;
import it.fides.cinema.service.GestioneSala;

@CrossOrigin
@RestController
public class SalaController {
		
	@Autowired
	private GestioneSala gestioneSala;

	

	@GetMapping(value = "/listaSale")
	public List<SalaDto> allSala(){
		return gestioneSala.showSala();
	}
	
	@PostMapping(value = "/insertSala")
	public String insertNewSala(@RequestBody SalaDto nuovaSala, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		
		if(RoleEnum.ADMIN.getRole().equals(role)) {

			if(gestioneSala.insertSala(nuovaSala.getNomeSala(), nuovaSala.getNumeroPosti())) {				
				return "Inserimento andato a buon fine";
			}
		}
		return "Errore";
	}
	
	@GetMapping(value = "/deleteSala")
	public String deleteSala(@RequestParam Long id) {
		gestioneSala.deleteSala(id);
		
		return "Operazione avvenuta con successo";
	}
		
}
