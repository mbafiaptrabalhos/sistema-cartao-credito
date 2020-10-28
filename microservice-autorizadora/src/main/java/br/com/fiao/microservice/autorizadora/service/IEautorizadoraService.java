package br.com.fiao.microservice.autorizadora.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiao.microservice.autorizadora.entity.Compra;

@Repository
public interface IEautorizadoraService extends MongoRepository<Compra, String> {
	
}
