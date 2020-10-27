package br.com.fiap.microservice.alunos.repository;

import java.util.List;

import br.com.fiap.microservice.alunos.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
