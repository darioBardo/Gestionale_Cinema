package it.fides.cinema.entity;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
public class Persona {
	
	@Id
	@SequenceGenerator(name = "userGen", sequenceName = "userid_gen", schema = "\"dario\"" , allocationSize = 1)
	@GeneratedValue(generator = "userGen", strategy = GenerationType.SEQUENCE)
	@OrderBy("id asc")
	private Long id;
	
	@Column
	private Date dataNascita; 
	
	@Column
	private String	username;
	
	@Column
	private String	password;
	
	@Column
	private String	nome;
	
	@Column
	private String	cognome;
	
	@Column
	private String	email;
	
	@Column
	private String	ruolo;
	
	@OneToMany(targetEntity = Biglietto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idPersona")
	private Set<Biglietto> bigliettiSet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Set<Biglietto> getBigliettiSet() {
		return bigliettiSet;
	}

	public void setBigliettiSet(Set<Biglietto> bigliettiSet) {
		this.bigliettiSet = bigliettiSet;
	}

	
	
}
