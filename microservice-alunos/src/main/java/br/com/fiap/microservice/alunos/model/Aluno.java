package br.com.fiap.microservice.alunos.model;

import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aluno {
	
	@Id
    private String rmAluno;
    private String nome;
    private boolean ativo;
 
    public Aluno() {}

	public Aluno(AlunoCreateUpdateDTO alunoCreateUpdateDTO) {
		this.rmAluno = alunoCreateUpdateDTO.getRmAluno();
		this.nome = alunoCreateUpdateDTO.getNome();
		this.ativo = true;
    }


	@Override
    public String toString() {
    	return "rmAluno: " + rmAluno + "\nNome: " + nome;
    }

	public String getRmAluno() {
		return rmAluno;
	}

	public void setRmAluno(String rmAluno) {
		this.rmAluno = rmAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
