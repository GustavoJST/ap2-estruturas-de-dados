package atividade2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDuplamenteLigada<Livro> biblioteca = new ListaDuplamenteLigada<>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Menu de Opções ===");
            System.out.println("1. Adicionar Livro no Início");
            System.out.println("2. Adicionar Livro no Fim");
            System.out.println("3. Remover Primeiro Livro");
            System.out.println("4. Remover Último Livro");
            System.out.println("5. Buscar Livro por ID");
            System.out.println("6. Imprimir Livros na Ordem Original");
            System.out.println("7. Imprimir Livros na Ordem Inversa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String tituloInicio = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorInicio = scanner.nextLine();
                    int idInicio = biblioteca.gerarId();
                    Livro livroInicio = new Livro(idInicio, tituloInicio, autorInicio);
                    biblioteca.adicionarNoInicio(livroInicio);
                    break;

                case 2:
                    System.out.print("Digite o título do livro: ");
                    String tituloFim = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorFim = scanner.nextLine();
                    int idFim = biblioteca.gerarId();
                    Livro livroFim = new Livro(idFim, tituloFim, autorFim);
                    biblioteca.adicionarNoFim(livroFim);
                    break;

                case 3:
                    biblioteca.removerDoInicio();
                    break;

                case 4:
                    biblioteca.removerDoFim();
                    break;

                case 5:
                    System.out.print("Digite o ID do livro que deseja buscar: ");
                    int idBusca = scanner.nextInt();
                    biblioteca.buscarPorId(idBusca);
                    break;

                case 6:
                    System.out.println("Livros na ordem original:");
                    biblioteca.imprimirOrdemOriginal();
                    break;

                case 7:
                    System.out.println("Livros na ordem inversa:");
                    biblioteca.imprimirOrdemReversa();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}