package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.SingletonDatabase;
import com.example.demo.dto.request.utente.LoginDTO;
import com.example.demo.dto.request.utente.RegistrazioneDTO;
import com.example.demo.model.Utente;

@RestController
@RequestMapping("/user")
public class UtenteController {
	
	@RequestMapping (method = RequestMethod.POST,path="/registra")
	public ResponseEntity<RegistrazioneDTO> registrazione(@RequestBody RegistrazioneDTO request) {
		if(request.isValid()) {
			Utente u = new Utente(request.getNome(),
								  request.getCognome(),
								  request.getEmail(),
								  request.getPassword());
			if(SingletonDatabase.getInstance().registraUtente(u)) {
				
				return ResponseEntity.status(HttpStatus.OK).build();
				
			}else {
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
				
			}
			
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@RequestMapping (method = RequestMethod.POST, path = "/login")
	public ResponseEntity<Utente> login(@RequestBody LoginDTO request){
		/*request.getUsername().equals("root")&& 
		 * request.getPassword().equals("root")
		 * */
		if(request.isValidLogin()) {
			long idUserSession = SingletonDatabase.getInstance().loginUtente(request.getEmail(), request.getPassword());
			if ( idUserSession != -1) {
				Utente u = SingletonDatabase.getInstance().getUtente(idUserSession);
				return ResponseEntity.status(HttpStatus.OK).body(u);
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}

}
