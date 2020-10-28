package br.com.fiap.microservice.alunos.service;


import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import br.com.fiap.microservice.alunos.model.Aluno;


import java.util.List;

public interface AlunoService {

    List<Aluno> findAll();

    Aluno findById(String id);

    Aluno create(AlunoCreateUpdateDTO aluno);

    Aluno update(AlunoCreateUpdateDTO aluno, String id);

    void delete(String id);

}
