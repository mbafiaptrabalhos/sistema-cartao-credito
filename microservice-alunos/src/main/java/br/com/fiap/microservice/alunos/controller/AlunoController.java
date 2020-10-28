package br.com.fiap.microservice.alunos.controller;

import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import br.com.fiap.microservice.alunos.model.Aluno;
import br.com.fiap.microservice.alunos.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService alunoService) {
        this.service = alunoService;
    }

    @GetMapping()
    @Operation(description = "Listagem de alunos")
      public ResponseEntity<List<Aluno>> getAllAlunos() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{matricula}")
    @Operation(description = "Listagem de alunos por matricula")
    public ResponseEntity<Aluno> getAlunoByMatricula(@PathVariable final String matricula) {
        return new ResponseEntity<>(service.findById(matricula), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Cadastro de alunos")
    public Aluno create(@RequestBody AlunoCreateUpdateDTO alunoCreateUpdateDTO) {
        return service.create(alunoCreateUpdateDTO);
    }

    @PutMapping("{id}")
    @Operation(description = "Update de alunos")
    public Aluno update(@RequestBody AlunoCreateUpdateDTO alunoCreateUpdateDTO, @PathVariable String id) {
        return service.update(alunoCreateUpdateDTO, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Remoção de alunos")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
