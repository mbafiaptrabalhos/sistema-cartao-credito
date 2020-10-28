package br.com.fiap.microservice.alunos.controller;

import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import br.com.fiap.microservice.alunos.service.AlunoServiceImpl;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AlunoControllerTests {


    @Test
    public void testCreate() {

        AlunoServiceImpl service = mock(AlunoServiceImpl.class);
        AlunoController controller = new AlunoController(service);

        AlunoCreateUpdateDTO aluno = new AlunoCreateUpdateDTO();
        aluno.setIdade(23);
        aluno.setRmAluno("123");
        aluno.setNome("Teste");

        controller.create(aluno);
        verify(service).create(aluno);
    }

    @Test
    public void testFindAll() {

        AlunoServiceImpl service = mock(AlunoServiceImpl.class);
        AlunoController controller = new AlunoController(service);

        controller.getAllAlunos();
        verify(service).findAll();
    }

    @Test
    public void testGetAlunoByMatricula() {

        AlunoServiceImpl service = mock(AlunoServiceImpl.class);
        AlunoController controller = new AlunoController(service);

        controller.getAlunoByMatricula("123");
        verify(service).findById("123");
    }

    @Test
    public void testUpdate() {

        AlunoServiceImpl service = mock(AlunoServiceImpl.class);
        AlunoController controller = new AlunoController(service);
        AlunoCreateUpdateDTO aluno = new AlunoCreateUpdateDTO();
        aluno.setIdade(23);
        aluno.setRmAluno("123");
        aluno.setNome("Teste");
        controller.update(aluno, "123");
        verify(service).update(aluno, "123");
    }

    @Test
    public void testDelete() {

        AlunoServiceImpl service = mock(AlunoServiceImpl.class);
        AlunoController controller = new AlunoController(service);

        controller.delete("123");
        verify(service).delete("123");
    }


}
