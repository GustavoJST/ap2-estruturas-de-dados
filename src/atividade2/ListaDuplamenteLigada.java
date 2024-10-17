package atividade2;

class ListaDuplamenteLigada<T> {
    private No<T> inicio;
    private No<T> fim;
    private static int contadorId = 1;

    public ListaDuplamenteLigada() {
        this.inicio = null;
        this.fim = null;
    }

    // Gerar novo ID automaticamente
    int gerarId() {
        return contadorId++;
    }

    // Adicionar no início
    public void adicionarNoInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        System.out.println("Adicionado no início: " + dado);
    }

    // Adicionar no fim
    public void adicionarNoFim(T dado) {
        No<T> novoNo = new No<>(dado);
        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        System.out.println("Adicionado no fim: " + dado);
    }

    // Remover do início
    public void removerDoInicio() {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println("Removido do início: " + inicio.dado);
            inicio = inicio.proximo;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }
        }
    }

    // Remover do fim
    public void removerDoFim() {
        if (fim == null) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println("Removido do fim: " + fim.dado);
            fim = fim.anterior;
            if (fim != null) {
                fim.proximo = null;
            } else {
                inicio = null;
            }
        }
    }

    // Buscar por ID
    public void buscarPorId(int id) {
        No<T> atual = inicio;
        while (atual != null) {
            Livro livro = (Livro) atual.dado;
            if (livro.id == id) {
                System.out.println("Livro encontrado: " + livro);
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Livro com ID " + id + " não encontrado.");
    }

    // Imprimir na ordem original
    public void imprimirOrdemOriginal() {
        No<T> atual = inicio;
        if (atual == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }

    // Imprimir na ordem inversa
    public void imprimirOrdemReversa() {
        No<T> atual = fim;
        if (atual == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.anterior;
        }
    }
}