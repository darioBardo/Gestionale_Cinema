package it.fides.cinema.entity;

import javax.persistence.*;

@Entity
public class Biglietto {
	
	@Id
	@SequenceGenerator(name = "idGeneratorBiglietto", sequenceName = "bigliettoid_gen", schema = "\"dario\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGeneratorBiglietto")
	private Long id;
	
	@Column
	private String fila;
	
	@Column
	private Long numero;
	
	@ManyToOne
	@JoinColumn(name = "id_proiezione", referencedColumnName = "id")
	private Proiezione idProiezione;
	
	@ManyToOne
	@JoinColumn(name="id_persona", referencedColumnName = "id")
	private Persona idPersona;

	
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

	public Proiezione getIdProiezione() {
		return idProiezione;
	}

	public void setIdProiezione(Proiezione idProiezione) {
		this.idProiezione = idProiezione;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}
	
	
	
	

}
