package br.com.fiap.microservice.alunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MicroserviceAlunosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAlunosApplication.class, args);
    }

}
