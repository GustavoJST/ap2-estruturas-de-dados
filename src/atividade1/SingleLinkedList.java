package atividade1;

public class SingleLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
