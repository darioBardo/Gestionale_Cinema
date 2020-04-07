package it.fides.cinema.dto;

import java.io.Serializable;
import java.util.Set;

public class SalaDto implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 210045653043383309L;
	private Long id;
	private String nomeSala;
	private Long numeroPosti;
	private ProiezioneDto proiezione;
	private Set<PostoDto> postiSet;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public Long getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(Long numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	public ProiezioneDto getProiezione() {
		return proiezione;
	}
	public void setProiezione(ProiezioneDto proiezione) {
		this.proiezione = proiezione;
	}
	public Set<PostoDto> getPostiSet() {
		return postiSet;
	}
	public void setPostiSet(Set<PostoDto> postiSet) {
		this.postiSet = postiSet;
	}
	
}
