package atividade1;

import java.util.ArrayList;

public class Pedido {
    private static int lastId = 1;
    private int id;
    private String descricao;

    public Pedido(String descricao) {
        this.id = lastId++;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static void exibirPedidos(ArrayList<Pedido> pedidos) {
        System.out.println("Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("- id: " + pedido.getId());
            System.out.println("  descrição: \"" + pedido.getDescricao() + "\"");
        }
    }

    public static void printDetalhes(Pedido pedido) {
        System.out.println("Detalhes do pedido:");
        System.out.println("- id: " + pedido.getId());
        System.out.println("  descrição: \"" + pedido.getDescricao() + "\"");
    }
}
