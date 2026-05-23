package model.entities;

import model.exceptions.DomainException;

public class Usuario {

    private static int gerar_matricula = 1;

    private Integer matricula;
    private String nome;
    private String numeroTelefone;
    private String email;

    public Usuario() {
    }

    public Usuario(String nome, String numeroTelefone, String email) {

        if(nome == null) {
            throw new DomainException("Nome inválido!");
        }
        if(numeroTelefone.length() != 11) {
            throw new DomainException("Número inválido!");
        }
        if(!email.contains("@") || !email.contains(".")) {
            throw new DomainException("Email inválido!");
        }

        this.matricula = gerar_matricula++;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "Matrícula: " + matricula + " - " +
                "Nome: " + nome + " - " +
                "Número: " + numeroTelefone + " - " +
                "Email: " + email;
    }
}
