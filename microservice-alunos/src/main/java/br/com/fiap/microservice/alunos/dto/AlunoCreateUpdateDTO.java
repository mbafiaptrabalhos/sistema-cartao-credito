package br.com.fiap.microservice.alunos.dto;

public class AlunoCreateUpdateDTO {

    private String rmAluno;
    private String nome;
    private String email;

    public AlunoCreateUpdateDTO() {
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRmAluno() {
        return rmAluno;
    }

    public void setRmAluno(String rmAluno) {
        this.rmAluno = rmAluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
