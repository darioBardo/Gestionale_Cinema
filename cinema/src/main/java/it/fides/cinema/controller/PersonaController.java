package it.fides.cinema.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.service.GestionePersona;

@CrossOrigin
@RestController
public class PersonaController {
	@Autowired
	private GestionePersona persona;
	
	//, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginDto(@RequestBody LoginDto login, HttpServletRequest request){
		
		PersonaDto user = persona.findUser(login);
		if(persona != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("role", user.getRuolo());
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> newUser(@RequestBody PersonaDto newUser, HttpServletRequest request){
		if(persona.createNewUser(newUser)) {
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
	

}
