package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegistrazioneDTO {
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String passwordRipetuta;
	
	public RegistrazioneDTO() {}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRipetuta() {
		return passwordRipetuta;
	}

	public void setPasswordRipetuta(String passwordRipetuta) {
		this.passwordRipetuta = passwordRipetuta;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return nome!=null && cognome!=null && email!=null 
				&& password!=null && passwordRipetuta!=null 
				&& !nome.isBlank() && !nome.isEmpty()
				&& !cognome.isBlank() && !cognome.isEmpty()
				&& email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
				//&& password.matches(regexPassword)
				&& password.equals(passwordRipetuta);
	}
	
	
}
