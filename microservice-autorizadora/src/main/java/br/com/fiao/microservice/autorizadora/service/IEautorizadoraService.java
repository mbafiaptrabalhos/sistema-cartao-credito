package br.com.fiao.microservice.autorizadora.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiao.microservice.autorizadora.entity.Compra;

public interface IEautorizadoraService extends MongoRepository<Compra, String> {
	
}
