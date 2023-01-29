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
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList() { 
        super(); 
    }
    
    @Override
    public void addToFront(T element) {
        T[] unorderedList = list;
        if(rear == unorderedList.length-1) {
            expandCapacity();
	}
        for (int i = rear; i > front; i--) {
            unorderedList[i] = unorderedList[i-1];
        }        
        unorderedList[front] = element;
	rear++;
        modCount++;
    }
    
    private void expandCapacity() {
        T[] unorderedList = list;
        int tam = unorderedList.length + 1;
        T[] temp = (T[])(new Object[tam]);
        for (int i = 0; i < rear; i++) {
            temp[i] = unorderedList[i];
        }
        unorderedList = temp;
    }

    @Override
    public void addToRear(T element) {
        T[] unorderedList = list;
        if(rear == unorderedList.length-1) {
            expandCapacity();
	}
        unorderedList[rear] = element;
	rear++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException {
        T[] unorderedList = list;
        if(rear == unorderedList.length-1) {
            expandCapacity();
        }
        int position = 0;
        for (int i = 0; i < rear; i++) {
            if (target.equals(unorderedList[i])) {
                position = i;
            }
            i++;
        }
           
        for (int j = rear; j > position; j--) {
            unorderedList[j] = unorderedList[j-1];
        }
        unorderedList[position+1] = element;
        rear++;
        modCount++;
    }
    
}
