/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.exceptions.EmptyCollectionException;

/**
 *
 * @author 8200335
 * @param <T>
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {
    /**
    * Adds the specified object to this heap.
    *
    * @param obj the element to added to this head
    */
    public void addElement (T obj);
   
    /**
    * Removes element with the lowest value from this heap.
    *
    * @return the element with the lowest value from this heap
     * @throws pt.ed2023.exceptions.EmptyCollectionException
    */
    public T removeMin() throws EmptyCollectionException;
   
    /**
    * Returns a reference to the element with the lowest value in
    * this heap.
    *
    * @return a reference to the element with the lowest value in this heap
     * @throws pt.ed2023.exceptions.EmptyCollectionException
    */
    public T findMin() throws EmptyCollectionException;
}
