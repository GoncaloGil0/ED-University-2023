/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.exceptions.EmptyCollectionException;
import pt.ed2023.exceptions.UnknownPathException;

/**
 * A interface NetworkADT representa uma rede abstrata de elementos. Uma rede é
 * uma estrutura de dados que pode ser usada para modelar relações entre
 * elementos.
 *
 * @author 8200335
 * @param <T>
 */
public interface NetworkADT<T> extends GraphADT<T> {

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     */
    public void addEdge(T vertex1, T vertex2, double weight) throws EmptyCollectionException;

    /**
     * Returns the weight of the shortest path in this network.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     * @throws pt.ed2023.exceptions.UnknownPathException
     */
    public ArrayUnorderedList<T> shortestPathWeight(T vertex1, T vertex2) throws EmptyCollectionException, UnknownPathException;
}
