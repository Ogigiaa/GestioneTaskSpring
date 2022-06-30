package com.example.demo.dto.request.task;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class InsertTaskDTO {
	
	private long idUtente;
	private String titolo;
	private String descrizione;
	private LocalDate dataScadenza;
	private String priority;
	private boolean fatta;
	
	public InsertTaskDTO() {}

	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

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
	
	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}

	@JsonIgnore
	public boolean isValidTask() {
		return titolo!=null 
				&& descrizione!=null 
				&& priority!=null 
				&& dataScadenza!=null
				&& !titolo.isEmpty() && !titolo.isBlank()
				&& !descrizione.isEmpty() && !descrizione.isBlank()
				&& !priority.isEmpty() && !priority.isBlank();
	}

}
