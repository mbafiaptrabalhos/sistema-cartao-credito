package com.fiap.microservice.extrato.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fiap.microservice.extrato.model.Aluno;

@Repository
public interface AlunoService extends MongoRepository<Aluno, String>{
	public Aluno findByRmAluno(String rmAluno);
}
