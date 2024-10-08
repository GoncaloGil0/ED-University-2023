/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.list;

import pt.ed2023.exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * * A classe ArrayList representa uma lista dinâmica de elementos
 * genéricos. Ela oferece as seguintes funcionalidades: 
 * - Adicionar um elemento ao final da lista 
 * - Inserir um elemento em uma posição específica 
 * - Remover um elemento por valor ou posição 
 * - Recuperar o tamanho atual da lista 
 * - Verificar se a lista está vazia 
 * - Recuperar um elemento de uma determinada posição
 *
 * @author 8200335
 * @param <T> O tipo de elemento a ser armazenado na lista
 */
public abstract class ArrayList<T> implements ListADT<T> {

    private final int SIZE = 100;
    protected T[] list;
    protected int front;
    protected int rear;
    protected int modCount;

    public ArrayList() {
        this.list = (T[]) (new Object[SIZE]);
        this.front = 0;
        this.rear = 0;
        this.modCount = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A lista está vazia");
        }
        T result = list[front];
        list[front] = null;
        for (int i = 0; i < this.rear; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.rear--;
        this.modCount++;
        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A lista está vazia");
        }
        this.rear--;
        T result = list[rear];
        list[rear] = null;
        this.modCount++;

        return result;
    }

    /**
     * Remove um elemento da lista.
     *
     * @param element O elemento a ser removido
     */
    @Override
    public T remove(T element) throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("A lista está vazia");
        }
        if (!contains(element)) {
            throw new EmptyCollectionException("Elemento não existe");
        }
        int position = 0;
        for (int i = 0; i < this.rear; i++) {
            if (element.equals(list[i])) {
                position = i;
            }
        }

        T result = list[position];
        list[position] = null;
        for (int j = position; j < this.rear; j++) {
            this.list[j] = this.list[j + 1];
        }
        this.rear--;
        this.modCount++;
        return result;
    }

    /**
     * Recupera o primeiro elemento da lista.
     *
     * @return O primeueiro elemento da lista
     * @throws EmptyCollectionException Se a lista estiver vazia
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A lista está vazia");
        }
        return list[front];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A lista está vazia");
        }
        return list[rear - 1];
    }

    public T get(int i) {
        if (i >= this.rear || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }
        return list[i];
    }

    @Override
    public boolean contains(T target) {
        boolean found = false;
        int i = 0;
        while (i < this.rear && !found) {
            if (list[i].equals(target)) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return True se a lista estiver vazia, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    /**
     * Retorna o tamanho atual da lista.
     *
     * @return O tamanho da lista
     */
    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }

    @Override
    public String toString() {
        String s = "ArrayList:\n";
        for (int i = 0; i < this.rear; i++) {
            s += list[i] + "\n";
        }
        return s;
    }

    public class BasicIterator<T> implements Iterator<T> {

        private final int size;
        private final T[] items;
        private int current;
        private int expectedModCount;

        public BasicIterator() {
            this.items = (T[]) ArrayList.this.list;
            this.size = ArrayList.this.rear;
            this.current = 0;
            this.expectedModCount = ArrayList.this.modCount;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Concorrência");
            }
            return (this.items[this.current] != null);
        }

        @Override
        public T next() {
            T temp = items[this.current];
            if (hasNext()) {
                this.current++;
            }
            return temp;
        }
    }
}
