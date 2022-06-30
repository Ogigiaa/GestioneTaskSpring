package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.SingletonDatabase;
import com.example.demo.dto.request.task.DeleteTaskDTO;
import com.example.demo.dto.request.task.ExecuteTaskDTO;
import com.example.demo.dto.request.task.InsertTaskDTO;
import com.example.demo.dto.request.task.StoricoTaskDTO;
import com.example.demo.dto.request.task.StoricoTaskEseguitiDTO;
import com.example.demo.model.Task;

@RestController
@RequestMapping("/user")
public class TaskController {
	
	@RequestMapping (method = RequestMethod.POST, path="/inserisciTask")
	public ResponseEntity <Task> inserimentoTask(@RequestBody InsertTaskDTO request){
		if(request.isValidTask()) {
			long idUserSession=request.getIdUtente();
			
			Task t = SingletonDatabase.getInstance()
									  .insertTask(request.getTitolo(),
											  	  idUserSession,
											  	  request.getDescrizione(),
											  	  request.getDataScadenza(),
											  	  request.getPriority());
			if(!t.equals(null)) {
				return ResponseEntity.status(HttpStatus.OK).body(t);
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();			
		}
	}
	
	@RequestMapping (method = RequestMethod.POST, path="/eliminaTask")
	public ResponseEntity <Task> eliminaTask(@RequestBody DeleteTaskDTO request){
		
		long idTaskToCancel = request.getIdTask();
		long idUserSession = request.getIdUtente();
		
		if(SingletonDatabase.getInstance().deleteTask(idTaskToCancel, idUserSession)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}		
		
	}
	
	@RequestMapping (method = RequestMethod.POST, path="/storicoTask")
	public ResponseEntity <List<Task>> storicoTask(@RequestBody StoricoTaskDTO request){
		
		long idUserSession = request.getIdUtente();
		
		List<Task> storicoTotale = new ArrayList<Task>(SingletonDatabase
														.getInstance()
														.storicoTask(idUserSession));
		if(!storicoTotale.equals(null)) {
			return ResponseEntity.status(HttpStatus.OK).body(storicoTotale);
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
	
	@RequestMapping (method = RequestMethod.POST, path="/eseguiTask")
	public ResponseEntity <Task> eseguiTask(@RequestBody ExecuteTaskDTO request){
		
		long idTaskToExecute = request.getIdTask();
		long idUserSession = request.getIdUtente();
		
		if(SingletonDatabase.getInstance().executeTask(idTaskToExecute, idUserSession)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
	@RequestMapping (method = RequestMethod.POST, path="/listaTaskEseguiti")
	public ResponseEntity <List<Task>> listaTaskEseguiti(@RequestBody StoricoTaskEseguitiDTO request){
		
		long idUserSession = request.getIdUtente();
		List<Task> storicoEseguiti = new ArrayList<Task>(SingletonDatabase
														.getInstance()
														.listaTaskEseguiti(idUserSession));
		if(!storicoEseguiti.equals(null)) {
			return ResponseEntity.status(HttpStatus.OK).body(storicoEseguiti);
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
}
