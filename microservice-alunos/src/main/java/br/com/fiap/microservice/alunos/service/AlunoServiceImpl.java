package br.com.fiap.microservice.alunos.service;


import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import br.com.fiap.microservice.alunos.model.Aluno;
import br.com.fiap.microservice.alunos.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno findById(String id) {
        return getAlunoById(id);
    }

    @Override
    public Aluno create(AlunoCreateUpdateDTO aluno) {
        return alunoRepository.save(new Aluno(aluno));
    }

    @Override
    public Aluno update(AlunoCreateUpdateDTO alunoUpdate, String id) {
        Aluno aluno = getAlunoById(id);
        aluno.setIdade(alunoUpdate.getIdade());
        aluno.setRmAluno(alunoUpdate.getRmAluno());
        aluno.setNome(alunoUpdate.getNome());

        Aluno savedAluno = alunoRepository.save(aluno);
        return savedAluno;
    }

    @Override
    public void delete(String id) {
        Aluno aluno = getAlunoById(id);
        aluno.setAtivo(false);
        alunoRepository.save(aluno);

    }

    private Aluno getAlunoById(String id) {
        return alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
