package atividade1;

import java.util.ArrayList;

public class Queue<T> {
    private SingleLinkedList<T> singleLinkedList;

    public Queue() {
        this.singleLinkedList = new SingleLinkedList<T>();
    }

    // Push element to the queue
    public void enqueue(T elemento) {
        Node<T> newNode = new Node<>(elemento);
        if (singleLinkedList.head == null) {
            singleLinkedList.head = newNode;
            singleLinkedList.tail = newNode; // If it's the first element, head and tail are the same
        } else {
            singleLinkedList.tail.next = newNode;
            singleLinkedList.tail = newNode;
        }
        singleLinkedList.size++;
    }

    // Remove an element following FIFO
    public Node<T> pop() {
        if (singleLinkedList.head == null) {
            System.out.println("[ERRO] A lista está vazia");
            return null;
        }

        Node<T> temp = singleLinkedList.head;
        singleLinkedList.head = singleLinkedList.head.next; // Move head to the next element

        if (singleLinkedList.head == null) {
            singleLinkedList.tail = null; // If the list is now empty, set tail to null
        }

        singleLinkedList.size--; // Decrement size
        return temp;             // Return the removed node
    }

    public T atenderPedido() {
        return pop().data;
    }

    public Node<T> cancelarPedido(Stack<T> pedidosCancelados) {
        Node<T> node = pop();
        pedidosCancelados.push(node.data);
        return node;
    }

    public Node<T> restaurarPedido(Stack<T> pedidosCancelados) {
        Node<T> node = pedidosCancelados.pop();
        enqueue(node.data);
        return node;
    }

    // Returns a list of all items on the queue
    public ArrayList<T> listQueue() {
        ArrayList<T> list = new ArrayList<T>();
        Node<T> currentNode = singleLinkedList.head;
        while (currentNode != null) {
            list.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return list;
    }
}
