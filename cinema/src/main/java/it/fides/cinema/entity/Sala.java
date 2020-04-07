package it.fides.cinema.entity;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Sala {
	
	@Id
	@SequenceGenerator(name = "idGeneratorSala", sequenceName = "salaid_gen", schema = "\"dario\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGeneratorSala")
	private Long id;
	
	@Column(name = "NOME_SALA")
	private String nomeSala;
	
	@Column(name = "NUMERO_POSTI")
	private Long numeroPosti;
	
	@JsonIgnore
	@OneToOne(mappedBy = "idSala")
	private Proiezione proiezione;
	
	@OneToMany(targetEntity = Posto.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "sala")
	@OrderBy("fila ASC, numero ASC")
	private Set<Posto> postiSet;

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

	public Proiezione getProiezione() {
		return proiezione;
	}

	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}

	public Set<Posto> getPostiSet() {
		return postiSet;
	}

	public void setPostiSet(Set<Posto> postiSet) {
		this.postiSet = postiSet;
	}
	
	
	
	
}