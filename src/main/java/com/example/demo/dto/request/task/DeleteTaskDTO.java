package com.example.demo.dto.request.task;


public class DeleteTaskDTO {

	private long idTask;
	private long idUtente;
	
	public DeleteTaskDTO() {}

	public long getIdTask() {
		return idTask;
	}

	public void setIdTask(long idTask) {
		this.idTask = idTask;
	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	
	
}
