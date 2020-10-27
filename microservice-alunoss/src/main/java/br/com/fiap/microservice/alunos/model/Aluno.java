package br.com.fiap.apialunos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aluno {
	
	@Id
    private String matricula;
    private String nome;
    private int idade;
 
    public Aluno() {}
    
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
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

}
