/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.network;

/**
 * A classe LinkedNode representa um nó em uma estrutura de dados encadeada.
 * Cada nó armazena um elemento e uma referência para o próximo nó na sequência.
 *
 * @author 8200335
 * @param <T>
 */
public class LinkedNode<T> {

    private LinkedNode<T> next;
    private T element;

    public LinkedNode() {
    }

    public LinkedNode(T element) {
        this.element = element;
        this.next = null;
    }

    public LinkedNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "LinkedNode{" + "element=" + element + '}';
    }
}
