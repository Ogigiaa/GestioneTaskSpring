package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginDTO {
	private String email;
	private String password;
	
	
	public LoginDTO() {}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}
	
	@JsonIgnore
	public boolean isValidLogin() {
		return email!=null && password!=null && !email.isBlank() && !email.isEmpty() && !password.isBlank() && !password.isEmpty();
	}
	
}
