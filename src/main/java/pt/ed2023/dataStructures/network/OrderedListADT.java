/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.dataStructures.list.ListADT;
import pt.ed2023.exceptions.NonComparableElementException;

/**
 * A interface OrderedListADT representa uma lista ordenada abstrata de
 * elementos. Uma lista ordenada é uma estrutura de dados onde os elementos são
 * mantidos em ordem crescente ou decrescente.
 *
 * @author 8200335
 * @param <T>
 */
public interface OrderedListADT<T> extends ListADT<T> {

    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     * @throws pt.ed2023.exceptions.NonComparableElementException
     */
    public void add(T element) throws NonComparableElementException;
}
