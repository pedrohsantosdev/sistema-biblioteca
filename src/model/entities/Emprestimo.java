package model.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataRealDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(7);

        livro.setDisponivel(false);
    }

    public void devolverLivro() {

        dataRealDevolucao = LocalDate.now();

        long atraso = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);

        if(atraso > 0) {
            System.out.println("Livro devolvido com atraso de" + atraso + " dias!");
        }

        else {
            System.out.println("Livro devolvido no prazo previsto!");
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return
                "Livro: " + livro + " - " +
                "Usuário: " + usuario + " - " +
                "Data de empréstimo: " + dataEmprestimo + " - " +
                "Data de devolução: " + dataDevolucao;
    }
}
