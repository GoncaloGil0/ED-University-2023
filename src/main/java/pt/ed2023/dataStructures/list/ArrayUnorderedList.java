/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.list;

import pt.ed2023.exceptions.EmptyCollectionException;

/**
 * A classe ArrayUnorderedList representa uma lista não ordenada de elementos
 * genéricos. Ela oferece as seguintes funcionalidades: - Adicionar um elemento
 * ao início da lista - Adicionar um elemento ao final da lista - Inserir um
 * elemento antes de outro elemento específico - Inserir um elemento após outro
 * elemento específico - Remover um elemento por valor - Recuperar o tamanho
 * atual da lista - Verificar se a lista está vazia - Recuperar o primeiro
 * elemento da lista - Recuperar o último elemento da lista
 *
 * @param <T> O tipo de elemento a ser armazenado na lista
 * @author 8200335
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList() {
        super();
    }

    /**
     * Adiciona um elemento ao início da lista.
     *
     * @param element O elemento a ser adicionado
     */
    @Override
    public void addToFront(T element) {
        T[] unorderedList = list;
        if (rear == unorderedList.length - 1) {
            expandCapacity();
        }
        for (int i = rear; i > front; i--) {
            unorderedList[i] = unorderedList[i - 1];
        }
        unorderedList[front] = element;
        rear++;
        modCount++;
    }

    private void expandCapacity() {
        T[] unorderedList = list;
        int tam = unorderedList.length + 1;
        T[] temp = (T[]) (new Object[tam]);
        for (int i = 0; i < rear; i++) {
            temp[i] = unorderedList[i];
        }
        unorderedList = temp;
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param element O elemento a ser adicionado
     */
    @Override
    public void addToRear(T element) {
        T[] unorderedList = list;
        if (rear == unorderedList.length - 1) {
            expandCapacity();
        }
        unorderedList[rear] = element;
        rear++;
        modCount++;
    }

    /**
     * Insere um elemento após outro elemento específico.
     *
     * @param element O elemento a ser inserido
     * @param target O elemento após o qual o elemento será inserido
     */
    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException {
        T[] unorderedList = list;
        if (rear == unorderedList.length - 1) {
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
            unorderedList[j] = unorderedList[j - 1];
        }
        unorderedList[position + 1] = element;
        rear++;
        modCount++;
    }

}
