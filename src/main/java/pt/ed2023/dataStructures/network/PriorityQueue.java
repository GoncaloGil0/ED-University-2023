/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.exceptions.EmptyCollectionException;

/**
 * A classe PriorityQueue representa uma fila de prioridade, onde os elementos
 * são ordenados com base em uma ordem de prioridade específica.
 *
 * @author 8200335
 * @param <T>
 */
public class PriorityQueue<T> extends LinkedHeap<PriorityQueueNode<T>> {

    /**
     * Creates an empty priority queue.
     */
    public PriorityQueue() {
        super();
    }

    /**
     * Adds the given element to this PriorityQueue.
     *
     * @param object the element to be added to the priority queue
     * @param priority the integer priority of the element to be added
     */
    public void addElement(T object, int priority) {
        PriorityQueueNode<T> node = new PriorityQueueNode<>(object, priority);
        super.addElement(node);
    }

    /**
     * Removes the next highest priority element from this priority queue and
     * returns a reference to it.
     *
     * @return a reference to the next highest priority element in this queue
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     */
    public T removeNext() throws EmptyCollectionException {
        PriorityQueueNode<T> temp = super.removeMin();
        return temp.getElement();
    }
}
