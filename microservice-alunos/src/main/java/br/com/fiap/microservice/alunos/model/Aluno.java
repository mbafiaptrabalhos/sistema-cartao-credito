package br.com.fiap.microservice.alunos.model;

import br.com.fiap.microservice.alunos.dto.AlunoCreateUpdateDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aluno {
	
	@Id
    private String matricula;
    private String nome;
    private int idade;
    private boolean ativo;
 
    public Aluno() {}

	public Aluno(AlunoCreateUpdateDTO alunoCreateUpdateDTO) {
		this.matricula = alunoCreateUpdateDTO.getMatricula();
		this.nome = alunoCreateUpdateDTO.getNome();
		this.idade = alunoCreateUpdateDTO.getIdade();
		this.ativo = true;
    }


	@Override
    public String toString() {
    	return "\nNome: " + nome + " - idade: " + idade;
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
