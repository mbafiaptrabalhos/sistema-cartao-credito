package com.fiap.microservice.extrato.model;

import org.springframework.data.annotation.Id;

public class Aluno{

	
	@Id
	private String rmAluno;
	private String email;
	
	public String getRmAluno() {
		return rmAluno;
	}
	public void setRmAluno(String rmAluno) {
		this.rmAluno = rmAluno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
