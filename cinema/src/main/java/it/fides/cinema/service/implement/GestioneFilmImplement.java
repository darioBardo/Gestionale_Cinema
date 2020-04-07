package it.fides.cinema.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.entity.Film;
import it.fides.cinema.repository.FilmRepository;
import it.fides.cinema.service.GestioneFilm;

@Service
@Transactional
public class GestioneFilmImplement implements GestioneFilm{
	Mapper mapper = new DozerBeanMapper();
	
	@Autowired
	FilmRepository filmRepo;
	
	@Override
	public List<FilmDto> showFilm() {
		
		List<FilmDto> listaFilm = new ArrayList<FilmDto>();
		
		for(Film film : filmRepo.findByOrderByIdAsc()) {
			FilmDto filmDto = new FilmDto();
//			filmDto = mapper.map(film, FilmDto.class);
			filmDto.setId(film.getId());
			filmDto.setDurata(film.getDurata());
			filmDto.setGenere(film.getGenere());
			filmDto.setRegista(film.getRegista());
			filmDto.setTitolo(film.getTitolo());
			filmDto.setTrama(film.getTrama());
			listaFilm.add(filmDto);
		}
		
		return listaFilm;
	}

	@Override
	public boolean insertFilm(FilmDto film) {
		
		Film filmTransfer = new Film();
		filmTransfer = mapper.map(film, Film.class);
		
		if(filmRepo.save(filmTransfer) != null)
			return true;
		
		return false;
	}

	@Override
	public void deleteFilm(Long id) {
		filmRepo.deleteById(id);
	}
	
	
}
