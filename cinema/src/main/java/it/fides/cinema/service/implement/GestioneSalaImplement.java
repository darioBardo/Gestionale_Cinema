package it.fides.cinema.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.entity.Sala;
import it.fides.cinema.repository.SalaRepository;
import it.fides.cinema.service.GestionePosto;
import it.fides.cinema.service.GestioneSala;

@Service
@Transactional
public class GestioneSalaImplement implements GestioneSala{
	Mapper mapper = new DozerBeanMapper();
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private GestionePosto posto;

	@Override
	public List<SalaDto> showSala() {
		List<SalaDto> listaSaleDto = new ArrayList<SalaDto>();
		
		  for (Sala sala : salaRepository.findByOrderByIdAsc()) { 
			  SalaDto salaDto = new SalaDto();
			  salaDto.setId(sala.getId()); 
			  salaDto.setNomeSala(sala.getNomeSala());
			  salaDto.setNumeroPosti(sala.getNumeroPosti()); 
			  listaSaleDto.add(salaDto); 
		  }
		return listaSaleDto;
	}
	
	@Override
	public boolean insertSala(String nomeSala, Long numeroPosti) {
		SalaDto salaD = new SalaDto();
		Sala salaTransfer = new Sala();
		
		salaD.setNomeSala(nomeSala);
		salaD.setNumeroPosti(numeroPosti);
		salaD.setPostiSet(posto.generatePosti(salaD));
		
		salaTransfer = mapper.map(salaD, Sala.class);

		if(salaRepository.save(salaTransfer) != null) {
			return true;			
		}
		return false;
	}

	@Override
	public void deleteSala(Long id) {
		
		salaRepository.deleteById(id);
		
	}

	
}
