package it.fides.cinema.dto;

import java.io.Serializable;

public class BigliettoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1581661993082088289L;

	private Long id;

	private String fila;

	private Long numero;
	
	private ProiezioneDto idProiezione;
	
	private PersonaDto idPersona;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public ProiezioneDto getIdProiezione() {
		return idProiezione;
	}

	public void setIdProiezione(ProiezioneDto idProiezione) {
		this.idProiezione = idProiezione;
	}

	public PersonaDto getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(PersonaDto persona) {
		this.idPersona = persona;
	}
	
	
	
	
}
