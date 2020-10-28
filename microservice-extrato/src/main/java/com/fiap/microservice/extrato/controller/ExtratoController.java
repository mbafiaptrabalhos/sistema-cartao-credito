package com.fiap.microservice.extrato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.microservice.extrato.model.Aluno;
import com.fiap.microservice.extrato.model.Compra;
import com.fiap.microservice.extrato.service.AlunoService;
import com.fiap.microservice.extrato.service.EmailService;
import com.fiap.microservice.extrato.service.ExtratoService;


@RestController
@RequestMapping("/extrato")
@EnableMongoRepositories(basePackageClasses = {ExtratoService.class, AlunoService.class})
public class ExtratoController {
	
	private EmailService emailService;
	
	public ExtratoController(EmailService emailService) {
        this.emailService = emailService;
    }

	
	@Autowired
	public ExtratoService service;
	
	@Autowired
	public AlunoService alunoService;

	@GetMapping("/{rmAluno}/{email}")
    public ResponseEntity<Compra> extrato (@PathVariable("rmAluno") String rmAluno, @PathVariable("email") String email) {
		
		Compra extrato = new Compra();
		
		try {
			String extratoAluno = "";
			
			for (Compra extratoLista : service.findByRmAluno(rmAluno)) {
				extratoAluno = extratoLista.getDescricao() + " " + extratoLista.getValorCompra();
			}
			
			Aluno dadosAluno = alunoService.findByRmAluno(rmAluno);
			
			emailService.sendSimpleMessage(email, "Extrato", extratoAluno);
			
        } catch (Exception e) {
            return new ResponseEntity<Compra>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Compra>(extrato, HttpStatus.OK);
    }
}
