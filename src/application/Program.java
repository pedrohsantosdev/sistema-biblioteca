package application;

import model.service.BibliotecaService;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        BibliotecaService service = new BibliotecaService();

        int opcao;

        do {
            System.out.println("------ MENU -------");
            System.out.println();
            System.out.println("1 - CADASTRAR LIVRO");
            System.out.println("2 - CADASTRAR USUÁRIO");
            System.out.println("3 - LISTAR LIVROS");
            System.out.println("4 - LISTAR USUÁRIOS");
            System.out.println("5 - EMPRESTAR LIVRO");
            System.out.println("6 - DEVOLVER LIVRO");
            System.out.println("7 - VER LIVROS DISPÓNIVEIS");
            System.out.println("8 - VER EMPRÉSTIMOS ATIVOS");
            System.out.println("0 - SAIR DO PROGRAMA");
            System.out.println();

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:

                    System.out.print("Digite o nome do livro que deseja cadastrar: ");
                    String nomeLivro = sc.nextLine();
                    System.out.print("Entre com o nome do autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Digite o código do produto: ");
                    String codigo = sc.nextLine();

                    service.cadastrarLivro(nomeLivro, autor, codigo);

                    System.out.println("Livro cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = sc.nextLine();
                    System.out.print("Digite o número de telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Entre com o email: ");
                    String email = sc.nextLine();

                    service.cadastrarUsuario(nomeUsuario, telefone, email);

                    System.out.println("Usuário cadastrado com sucesso!");

                    break;

                case 3:

                    System.out.println("Listando livros: ");
                    service.listarLivros();

                    break;

                case 4:

                    System.out.println("Listando usuários cadastrados no sistema: ");
                    service.listarUsuarios();

                    break;

                case 5:

                    System.out.print("Digite a matrícula do usuário: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o código do livro: ");
                    String codigoLivro = sc.nextLine();

                   service.emprestarLivro(matricula, codigoLivro);

                    System.out.println("Empréstimo concluído!");

                   break;

                case 6:

                    System.out.print("Digite o ibns do livro que deseja devolver: ");
                    String codigoDevolucao = sc.nextLine();

                    service.devolverLivro(codigoDevolucao);

                    System.out.println("Livro devolvido com sucesso!");

                    break;

                case 7:

                    System.out.println("Listando livros dispóniveis");

                    service.livrosDisponiveis();

                    break;

                case 8:

                    System.out.println("Mostrando empréstimos ativos: ");

                    service.emprestimosAtivos();

                    break;

                case 0:

                    System.out.println("Saindo do programa!");

                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
