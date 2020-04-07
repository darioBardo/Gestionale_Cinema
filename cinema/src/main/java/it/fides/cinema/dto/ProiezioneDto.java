package it.fides.cinema.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class ProiezioneDto implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -491794985827280905L;
	private Long id;
	private Date dataProiezione;
	private Long postiDisponibili;
	private SalaDto idSala;
	private FilmDto idFilm;
	private Set<BigliettoDto> setBiglietti;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataProiezione() {
		return dataProiezione;
	}
	public void setDataProiezione(Date dataProiezione) {
		this.dataProiezione = dataProiezione;
	}
	public Long getPostiDisponibili() {
		return postiDisponibili;
	}
	public void setPostiDisponibili(Long postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	public SalaDto getIdSala() {
		return idSala;
	}
	public void setIdSala(SalaDto idSala) {
		this.idSala = idSala;
	}
	public FilmDto getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(FilmDto idFilm) {
		this.idFilm = idFilm;
	}
	public Set<BigliettoDto> getSetBiglietti() {
		return setBiglietti;
	}
	public void setSetBiglietti(Set<BigliettoDto> setBiglietti) {
		this.setBiglietti = setBiglietti;
	}
	
	

}
