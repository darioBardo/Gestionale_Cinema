package it.fides.cinema.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Test {
	
	@GetMapping(value = "/hello")
	public String ciao(@RequestParam String name, String surname) {
		return "Hello! " + name + " " + surname;
	}
	
	
	@PostMapping(value = "/postExample")
	public @ResponseBody ResponseEntity<String> sayHello() {
		return new ResponseEntity<String> ("Hi there this is POST", HttpStatus.OK);
	}
	
	
	
		
		
		
		
	
}
