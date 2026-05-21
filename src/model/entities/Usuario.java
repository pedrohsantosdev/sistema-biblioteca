package model.entities;

public class Usuario {

    private static int gerar_matricula = 1;

    private String nome;
    private Integer matricula;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
        this.matricula = gerar_matricula++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return
                "Nome: " + nome + " - " +
                "Matrícula: " + matricula;
    }
}
