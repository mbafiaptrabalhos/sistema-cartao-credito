package br.com.fiao.microservice.autorizadora.autorizadora;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import br.com.fiao.microservice.autorizadora.service.IEautorizadoraService;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class AutorizadoraApplicationTests {
	
	@Autowired public IEautorizadoraService service;
	
	@Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
		DBObject objectToSave = BasicDBObjectBuilder.start()
	            .add("rmAluno", "1234")
	            .add("valorCompra", new BigDecimal(15.00))
	            .add("descricao", "Compra teste")
	            .add("data", "10/10/2020")
	            .get();
		
		mongoTemplate.save(objectToSave, "collection");
	}

}
