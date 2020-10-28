package br.com.fiap.batchcargaalunos.dominio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aluno {

    private String nome;
    @Id
    private String rm;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "Nome='" + nome + "'" +
                ", RM ='" + rm + "'" +
                '}';
    }
}
