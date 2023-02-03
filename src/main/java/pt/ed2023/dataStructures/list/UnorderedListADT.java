/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.list;

import pt.ed2023.exceptions.EmptyCollectionException;

/**
 *
 * @author 8200335
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T> {

    /**
     * Adds the specified element to the front of the list
     *
     * @param element the element to be added to this list
     */
    public void addToFront(T element);

    /**
     * Adds the specified element to the rear of the list
     *
     * @param element the element to be added to this list
     */
    public void addToRear(T element);

    /**
     * Adds the specified element after a particular element already in the list
     *
     * @param element the element to be added to this list
     * @param target the target element already in the list
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     */
    public void addAfter(T element, T target) throws EmptyCollectionException;
}
