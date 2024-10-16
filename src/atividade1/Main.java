package atividade1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Pedido> pedidosPendentes = new Queue<>();
        Stack<Pedido> pedidosCancelados = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equalsIgnoreCase("q")) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("Digite 'q' para sair.");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("\nDigite a descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    Pedido novoPedido = new Pedido(descricao);
                    pedidosPendentes.enqueue(novoPedido);
                    System.out.println("\nPedido adicionado com sucesso!");
                    break;

                case "2":
                    if (pedidosPendentes.listQueue().isEmpty()) {
                        System.out.println("\nNenhum pedido pendente para atender.");
                    } else {
                        Pedido pedidoAtendido = pedidosPendentes.atenderPedido();
                        System.out.println("\nPedido atendido:");
                        Pedido.printDetalhes(pedidoAtendido);
                    }
                    break;

                case "3":
                    if (pedidosPendentes.listQueue().isEmpty()) {
                        System.out.println("\nNenhum pedido pendente para cancelar.");
                    } else {
                        Pedido pedidoCancelado = pedidosPendentes.cancelarPedido(pedidosCancelados).data;
                        System.out.println("\nPedido cancelado:");
                        Pedido.printDetalhes(pedidoCancelado);
                    }
                    break;

                case "4":
                    if (pedidosCancelados.listStack().isEmpty()) {
                        System.out.println("\nNenhum pedido cancelado para restaurar.");
                    } else {
                        Pedido pedidoRestaurado = pedidosPendentes.restaurarPedido(pedidosCancelados).data;
                        System.out.println("\nPedido restaurado:");
                        Pedido.printDetalhes(pedidoRestaurado);
                    }
                    break;

                case "5":
                    if (pedidosPendentes.listQueue().isEmpty()) {
                        System.out.println("\nNenhum pedido pendente.");
                    } else {
                        System.out.println("\nPedidos Pendentes:");
                        Pedido.exibirPedidos(pedidosPendentes.listQueue());
                    }
                    break;

                case "6":
                    if (pedidosCancelados.listStack().isEmpty()) {
                        System.out.println("\nNenhum pedido cancelado.");
                    } else {
                        System.out.println("\nPedidos Cancelados:");
                        Pedido.exibirPedidos(pedidosCancelados.listStack());
                    }
                    break;

                case "q":
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("A tecla " + option + " não é reconhecida pelo programa.");
                    break;
            }
        }
        scanner.close();
    }
}
