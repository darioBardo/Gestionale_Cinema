package it.fides.cinema.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.entity.Proiezione;
import it.fides.cinema.repository.ProiezioneRepository;
import it.fides.cinema.repository.ProiezioneRepository.OnlyPosto;
import it.fides.cinema.service.GestioneProiezione;

@Service
@Transactional
public class GestioneProiezioneImplement implements GestioneProiezione {
	Mapper mapper = new DozerBeanMapper();
	Conversioni convert = new Conversioni();
	
	@Autowired
	ProiezioneRepository proiezioneRepo;
	
	
	@Override
	public List<ProiezioneDto> showProiezioni() {
		
		List<ProiezioneDto> listaProiezioni = new ArrayList<ProiezioneDto>();
		
		
		
		for(Proiezione proiezione : proiezioneRepo.findAll()) {
		
			ProiezioneDto proiezioneDto = new ProiezioneDto();
			proiezioneDto.setId(proiezione.getId());
			proiezioneDto.setDataProiezione(proiezione.getDataProiezione());
			proiezioneDto.setPostiDisponibili(proiezioneRepo.contaPostiLiberi(proiezione.getId()));
			//proiezioneDto.setIdSala(convert.convertToSalaDto(proiezione.getIdSala()));
//			FilmDto filmDto = mapper.map(proiezione.getIdFilm(), FilmDto.class);
//			proiezioneDto.setIdFilm(filmDto);
			
			listaProiezioni.add(proiezioneDto);
		}
		
		return listaProiezioni;
	}

	@Override
	public boolean insertProiezione(ProiezioneDto nuovaProiezione) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteProiezione(ProiezioneDto oldProiezione) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostoDto> mostraPostiDisponibili(Long idProiezione) {
		
		List<OnlyPosto> posti = proiezioneRepo.ottieniPostiLiberi(idProiezione);
		List<PostoDto> postiDisponibili = new ArrayList<PostoDto>();
		
		for (OnlyPosto posto : posti) {
			PostoDto postoDto = new PostoDto();
			postoDto.setId(posto.getId());
			postoDto.setFila(posto.getFila());
			postoDto.setNumero(posto.getNumero());
			
			postiDisponibili.add(postoDto);
		}
		
		return postiDisponibili;
	}

	@Override
	public Long contaPostiDisponibili(Long idProiezione) {
		return proiezioneRepo.contaPostiLiberi(idProiezione);
	}

}
