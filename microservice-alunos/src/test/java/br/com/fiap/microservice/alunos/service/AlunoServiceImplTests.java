package br.com.fiap.microservice.alunos.service;

import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import br.com.fiap.microservice.alunos.model.Aluno;
import br.com.fiap.microservice.alunos.repository.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.verify;

public class AlunoServiceImplTests {

    @Test
    public void testFindAll() {
        AlunoRepository repository = mock(AlunoRepository.class);
        List<Aluno> list = new ArrayList<>();

        Aluno aluno = new Aluno();
        aluno.setNome("Teste");
        aluno.setMatricula("123");
        aluno.setIdade(25);

        list.add(aluno);

        when(repository.findAll()).thenReturn(list);

        AlunoService alunoService = new AlunoServiceImpl(repository);
        List<Aluno> alunos = alunoService.findAll();
        assertEquals(1, alunos.size());
    }

    @Test
    public void testFindById() {
        AlunoRepository repository = mock(AlunoRepository.class);
        List<Aluno> list = new ArrayList<>();

        Aluno aluno = new Aluno();
        aluno.setNome("Teste");
        aluno.setMatricula("123");
        aluno.setIdade(25);

        list.add(aluno);

        when(repository.findById("123")).thenReturn(Optional.of(aluno));

        AlunoService alunoService = new AlunoServiceImpl(repository);
        Aluno alunoGetById = alunoService.findById("123");
        assertEquals(aluno, alunoGetById);
    }

    @Test
    public void testCreate() {
        AlunoRepository repository = mock(AlunoRepository.class);
        AlunoCreateUpdateDTO aluno = new AlunoCreateUpdateDTO();
        aluno.setIdade(23);
        aluno.setMatricula("123");
        aluno.setNome("Teste");

        AlunoService alunoService = new AlunoServiceImpl(repository);
        alunoService.create(aluno);
        verify(repository).save(any(Aluno.class));
    }

    @Test
    public void testUpdate() {
        AlunoRepository repository = mock(AlunoRepository.class);
        AlunoCreateUpdateDTO alunoCreateUpdateDTO = new AlunoCreateUpdateDTO();
        alunoCreateUpdateDTO.setIdade(23);
        alunoCreateUpdateDTO.setMatricula("123");
        alunoCreateUpdateDTO.setNome("Teste");

        Aluno aluno = new Aluno(alunoCreateUpdateDTO);
        when(repository.findById("123")).thenReturn(Optional.of(aluno));

        AlunoService alunoService = new AlunoServiceImpl(repository);
        alunoService.update(alunoCreateUpdateDTO, "123");
        verify(repository).save(any(Aluno.class));
    }

    @Test
    public void testDelete() {
        AlunoRepository repository = mock(AlunoRepository.class);
        AlunoCreateUpdateDTO alunoCreateUpdateDTO = new AlunoCreateUpdateDTO();
        alunoCreateUpdateDTO.setIdade(23);
        alunoCreateUpdateDTO.setMatricula("123");
        alunoCreateUpdateDTO.setNome("Teste");

        Aluno aluno = new Aluno(alunoCreateUpdateDTO);
        when(repository.findById("123")).thenReturn(Optional.of(aluno));

        AlunoService alunoService = new AlunoServiceImpl(repository);
        alunoService.delete("123");
        verify(repository).save(any(Aluno.class));
        assertFalse(aluno.isAtivo());
    }
}


