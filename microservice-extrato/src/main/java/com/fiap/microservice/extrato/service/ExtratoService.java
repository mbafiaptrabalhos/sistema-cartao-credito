package com.fiap.microservice.extrato.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fiap.microservice.extrato.model.Compra;

@Repository
public interface ExtratoService extends MongoRepository<Compra, String>{
	public List<Compra> findByRmAluno(String rmAluno);
	
}
