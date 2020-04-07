package it.fides.cinema.service.implement;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.entity.Persona;
import it.fides.cinema.repository.PersonaRepository;
import it.fides.cinema.service.GestionePersona;

@Service
@Transactional
public class GestionePersonaImplement implements GestionePersona{
	Mapper mapper = new DozerBeanMapper();
	
	@Autowired
	PersonaRepository personaRepo;

	@Override
	public PersonaDto findUser(LoginDto login) {
		
		Persona persona = personaRepo.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		PersonaDto personaDto = new PersonaDto();
		personaDto.setRuolo(persona.getRuolo());
		
		return personaDto;
	}
	
	public boolean createNewUser(PersonaDto newUserDto) {
		
		if(!personaRepo.existsByUsername(newUserDto.getUsername()) ){
			newUserDto.setRuolo("utente");
			Persona newUser = mapper.map(newUserDto, Persona.class);
			
			if(personaRepo.save(newUser)!= null){ 
				return true;
			}
		}
		return false;
	}
	
	
}
