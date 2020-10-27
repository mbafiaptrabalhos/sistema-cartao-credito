package br.com.fiap.microservice.alunos.dto;

import br.com.fiap.microservice.alunos.model.Aluno;

public class AlunoCreateUpdateDTO {

    private String matricula;
    private String nome;
    private int idade;

    public AlunoCreateUpdateDTO() {
    }


    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
