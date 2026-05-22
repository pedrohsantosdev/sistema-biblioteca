package model.service;

import model.entities.Emprestimo;
import model.entities.Livro;
import model.entities.Usuario;
import model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(String nome, String autor, String codigo) {
        livros.add(new Livro(nome, autor, codigo));
    }

    public void cadastrarUsuario(String nome, String telefone, String email) {
        usuarios.add(new Usuario(nome, telefone, email));
    }

    public Livro encontrarLivro(String nome) {

        return livros.stream().filter(l -> l.getNome().equalsIgnoreCase(nome)).
                findFirst().
                orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

    }

    public void listarLivros() {

        for(Livro l : livros) {
            System.out.println(l);
        }
    }

    public void listarUsuarios() {

        for(Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public void emprestarLivro(int matricula, String ibns) {

        Usuario usarioEncontrado = null;
        Livro livroEncontrado = null;

        for(Usuario u : usuarios) {
            if(u.getMatricula() == matricula) {
                usarioEncontrado = u;
            }
        }

        for(Livro l : livros) {
            if(l.getIsbn().equals(ibns)) {
                livroEncontrado = l;
            }
        }

        if(usarioEncontrado == null) {
            throw new DomainException("Usuário inválido!");
        }

        if(livroEncontrado == null) {
            throw new DomainException("Livro não encontrado!");
        }

        Emprestimo emp = new Emprestimo(livroEncontrado, usarioEncontrado);

        emprestimos.add(emp);
    }

    public void devolverLivro(String ibns) {

        Emprestimo empEncontrado = null;

        for(Emprestimo emp : emprestimos) {

            if(emp.getLivro().getIsbn().equals(ibns)) {
                empEncontrado = emp;
            }
        }

        if(empEncontrado == null) {
            throw new DomainException("Empréstimo não encontrado!");
        }

        empEncontrado.devolverLivro();
    }



}
