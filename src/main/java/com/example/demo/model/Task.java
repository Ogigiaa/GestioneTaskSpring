package com.example.demo.model;

import java.time.LocalDate;

public class Task {

	private long id;
	private Utente utente;
	private String titolo;
	private String descrizione;
	private LocalDate dataScadenza;
	private String priority;
	private boolean fatta;
	private boolean eliminata;
	
	public Task() {}

	public Task(String titolo, Utente utente, String descrizione, LocalDate dataScadenza, String priority, boolean fatta, boolean eliminata) {
		super();
		this.titolo = titolo;
		this.utente = utente;
		this.descrizione = descrizione;
		this.dataScadenza = dataScadenza;
		this.priority = priority;
		this.fatta = fatta;
		this.eliminata = eliminata;
	}

	public Task(long id, String titolo, Utente utente, String descrizione, LocalDate dataScadenza, String priority, boolean fatta, boolean eliminata) {
		super();
		this.id = id;
		this.utente = utente;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.dataScadenza = dataScadenza;
		this.priority = priority;
		this.fatta = fatta;
		this.eliminata = eliminata;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean isFatta() {
		return fatta;
	}

	public void setFatta(boolean fatta) {
		this.fatta = fatta;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public boolean isEliminata() {
		return eliminata;
	}

	public void setEliminata(boolean eliminata) {
		this.eliminata = eliminata;
	}


}
