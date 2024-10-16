package atividade1;

import java.util.ArrayList;

public class Stack<T> {
    private SingleLinkedList<T> singleLinkedList;

    public Stack() {
        this.singleLinkedList = new SingleLinkedList<T>();
    }

    // Push element to the stack
    public void push(T elemento) {
        Node<T> newNode = new Node<>(elemento);
        if (singleLinkedList.head == null) {
            singleLinkedList.head = newNode;
            singleLinkedList.tail = newNode; // If it's the first element, head and tail are the same
        } else {
            Node<T> temp = singleLinkedList.head;
            singleLinkedList.head = newNode;
            singleLinkedList.head.next = temp;
        }
    }

    // Remove an element following LIFO
    public Node<T> pop() {
        if (singleLinkedList.head == null) {
            System.out.println("[ERRO] A lista está vazia");
            return null;
        }

        if (singleLinkedList.head.next == null) {
            Node<T> temp = singleLinkedList.head;
            singleLinkedList.head = null;
            singleLinkedList.tail = null; // Set tail to null as the stack becomes empty
            singleLinkedList.size--;
            return temp;
        }

        Node<T> currentNode = singleLinkedList.head;
        Node<T> previousNode = null;

        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // Remove last element and update tail
        previousNode.next = null;
        singleLinkedList.tail = previousNode; // Update tail to be the second-to-last node
        singleLinkedList.size--;
        return currentNode;                   // Return the data of the removed node
    }

    // Returns a list of all items on the queue
    public ArrayList<T> listStack() {
        ArrayList<T> list = new ArrayList<T>();
        Node<T> currentNode = singleLinkedList.head;
        while (currentNode != null) {
            list.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return list;
    }
}
