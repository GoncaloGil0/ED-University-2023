/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.dataStructures.list.ArrayList;
import pt.ed2023.exceptions.NonComparableElementException;

/**
 *
 * @author 8200335
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() { 
        super();
    }
    
    @Override
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) 
            throw new NonComparableElementException("O elemento ou classe não é comparável");
        if(size() == list.length) {
            expandCapacity();
	}
        
        Comparable<T> temp = (Comparable<T>)element;
        int index = 0;
        
        while(index < rear && temp.compareTo(list[index]) > 0) {
            index++;
        }
        
        for (int j = this.rear; j > index; j--) {
            list[j] = list[j-1];
        }
        this.list[index] = element;
	rear++;	
        modCount++;
    }
    
    private void expandCapacity() {
        int tam = list.length + 1;
        T[] temp = (T[])(new Object[tam]);
        for (int i = 0; i < rear; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }
}
