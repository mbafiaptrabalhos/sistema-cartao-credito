package br.com.fiap.apialunos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apialunos.model.Aluno;
import br.com.fiap.apialunos.repository.AlunoRepository;

@RestController
@RequestMapping(name = "api")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> getAllAlunos(@RequestParam(required = false) String nome) {

		try {
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			if (nome == null) {
				alunoRepository.findAll().forEach(alunos::add);
			} else {
				alunoRepository.findByNomeLike(nome).forEach(alunos::add);
			}
			
			if (alunos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(alunos, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/alunos/{matricula}")
	public ResponseEntity<Aluno> getAlunoByMatricula(@PathVariable("matricula") String matricula) {

		Optional<Aluno> alunoConsulta = alunoRepository.findById(matricula);
		
		if (alunoConsulta.isPresent()) {
			return new ResponseEntity<>(alunoConsulta.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/alunos")
	public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {

		try {
			
			Aluno alunoResponse = alunoRepository.save(new Aluno(aluno.getNome(), aluno.getIdade()));
			return new ResponseEntity<Aluno>(alunoResponse, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/alunos/{matricula}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable("matricula") String matricula, @RequestBody Aluno aluno) {

		Optional<Aluno> alunoConsulta = alunoRepository.findById(matricula);
		
		if (alunoConsulta.isPresent()) {
			Aluno alunoResponse = alunoConsulta.get();
			alunoResponse.setNome(aluno.getNome());
			alunoResponse.setIdade(aluno.getIdade());
			
			return new ResponseEntity<>(alunoRepository.save(alunoResponse), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/alunos/{matricula}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable("matricula") String matricula) {

		try {
			
			alunoRepository.deleteById(matricula);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/alunos")
	public ResponseEntity<Aluno> deleteAllAlunos() {

		try {
			
			alunoRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
