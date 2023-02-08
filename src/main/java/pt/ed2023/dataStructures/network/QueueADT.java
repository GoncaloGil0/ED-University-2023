/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.exceptions.EmptyCollectionException;

/**
 ** A interface QueueADT representa uma fila abstrata de elementos. Uma fila é
 * uma estrutura de dados onde os elementos são inseridos no final e retirados
 * na ordem em que foram adicionados.
 *
 * @author 8200335
 * @param <T>
 */
public interface QueueADT<T> {

    /**
     * Adiciona um elemento à parte de trás desta fila.
     *
     * @param element o elemento a ser adicionado à parte de trás desta fila
     */
    public void enqueue(T element);

    /**
     * Remove e devolve o elemento na frente desta fila.
     *
     * @return o elemento na frente desta fila
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Regressa sem remover o elemento na frente desta fila.
     *
     * @return o primeiro elemento desta fila
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    public int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString();
}
