package br.com.fiap.batchcargaalunos.dominio;

public class Aluno {

    private String nome;
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
