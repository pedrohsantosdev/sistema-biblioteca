package model.entities;

import model.exceptions.DomainException;

public class Livro {

    private String nome;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro() {
    }

    public Livro(String nome, String autor, String isbn) {

        if(nome == null) {
            throw new DomainException("Nome inválido!");
        }
        if(autor == null) {
            throw new DomainException("Nome inválido!");
        }
        if(isbn == null ) {
            throw new DomainException("Código inválido!");
        }

        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + " - " +
                "Autor: " + autor + " - " +
                "isbn: " + isbn + " - " +
                "status: " + disponivel;
    }
}
