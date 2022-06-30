package com.example.demo.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Task;
import com.example.demo.model.Utente;

public class SingletonDatabase {
	
	private static SingletonDatabase instance = new SingletonDatabase();
	
	private SingletonDatabase () {}
	
	public static SingletonDatabase getInstance() {
		return instance;
	}
	
	private List<Utente> utenti = new ArrayList<Utente>();
	private List<Task> tasks = new ArrayList<Task>();
	
	private static long idUtenteGen=1;
	private static long idTaskGen=1;
	
	
	public boolean registraUtente(Utente u) {
		//prendo tutti gli utenti nella stream
		if (utenti.stream()
				//converto in una lista gli utenti
				//delle loro mail
				.map(s->s.getEmail())
				//se almeno una delle mail salvate ha un match con quella che voglio inserire
				.anyMatch(s->s.equals(u.getEmail()))){
			//l'email è già stata registrata, quindi non posso accettarla
			return false;
		}else {
			u.setId(idUtenteGen++);
			utenti.add(u);
			return true;
		}
	}
		
	
	public long loginUtente(String email, String password) {
		Optional<Utente> find = utenti.stream()
		.filter(s->s.getEmail().equals(email) && s.getPassword().equals(password))
		.findFirst();
		
		if(find.isPresent()) {
			return find.get().getId();
			
		}else {
			return -1;
		}
	}
	
	/*
	public long loginUtente(String email, String password) {
		long idUser=-1;
		for(Utente u:utenti) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password))	{
				idUser = u.getId();
			}
		}
		return idUser;
	}
	*/
	
	
	public Utente getUtente(long id) {
		for(Utente u : utenti) {
			if (id == u.getId()) {
				return u;						
			}
		}
			return null;		
	}
	
	
	public Task insertTask(String titolo, long idUtente, String descrizione, LocalDate dataScadenza, String priority) {
		//controllo se l'utente loggato esiste o meno
		Utente u = getUtente(idUtente);
		if(u != null) {
			Task t = new Task(titolo, u, descrizione, dataScadenza, priority, false, false);
			t.setId(idTaskGen++);
			tasks.add(t);
			return t;			
		}else {			
			//non ho trovato match ritorno null
			return null;
		}
	}
	
	public boolean deleteTask(long idTask, long idUser) {
		
		Utente u = getUtente(idUser);
		for(Task t : tasks) {
			if(t.getId() == idTask && t.getUtente().equals(u)) {
				t.setEliminata(true);
				return true;
			}
		}
		return false;
	}
	
	public boolean executeTask(long idTask, long idUtente) {		
		Utente u = getUtente(idUtente);
		
		for(Task t : tasks) {
			if(t.getId() == idTask && t.getUtente().equals(u) && t.isFatta() == false) {
				t.setFatta(true);
				return true;
			}
		}
		return false;
	}
	
	public List<Task> listaTaskEseguiti(long idUtente){
		
		List<Task> listaTaskUser = new ArrayList<Task>();
		Utente u = getUtente(idUtente);
		for(Task t :tasks) {
			if(t.getUtente().equals(u) && t.isFatta() == true && t.isEliminata() == false) {
				listaTaskUser.add(t);
			}
		}
		if (listaTaskUser.equals(null)) {
			return null;
		}else {
			return listaTaskUser;
		}
	}
	
	
	
	public List<Task> listaTaskToDo(long idUtente){
		
		List<Task> listaTaskUser = new ArrayList<Task>();
		Utente u = getUtente(idUtente);
		for(Task t :tasks) {
			if(t.getUtente().equals(u) && t.isFatta() == false && t.isEliminata() == false) {
				listaTaskUser.add(t);
			}
		}
		if (listaTaskUser.equals(null)) {
			return null;
		}else {
			return listaTaskUser;
		}
	}
	
	
	public List<Task> storicoTask(long idUtente){
		
		List <Task> storicoTask = new ArrayList<Task>();		
		Utente u = getUtente(idUtente);
		for(Task t : tasks) {
			if (t.getUtente().equals(u)){
				storicoTask.add(t);
			}
		}
		if (storicoTask.equals(null)) {
			return null;
		}else {
			return storicoTask;
		}
		
	}

}
