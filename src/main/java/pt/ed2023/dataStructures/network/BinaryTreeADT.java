/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import pt.ed2023.exceptions.ElementNotFoundException;
import pt.ed2023.exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * A interface BinaryTreeADT representa uma árvore binária abstrata de
 * elementos. Uma árvore binária é uma estrutura de dados onde cada nó pode ter
 * até dois filhos (esquerdo e direito).
 *
 * @author 8200335
 * @param <T>
 */
public interface BinaryTreeADT<T> {

    /**
     * Returns a reference to the root element
     *
     * @return a reference to the root
     * @throws pt.ed2023.exceptions.EmptyCollectionException
     */
    public T getRoot() throws EmptyCollectionException;

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this binary tree.
     *
     * @return the integer number of elements in this tree
     */
    public int size();

    /**
     * Returns true if the binary tree contains an element that matches the
     * specified element and false otherwise.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T targetElement);

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree. Throws a NoSuchElementException if the specified target
     * element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    public T find(T targetElement) throws ElementNotFoundException;

    /**
     * Returns the string representation of the binary tree.
     *
     * @return a string representation of the binary tree
     */
    @Override
    public String toString();

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorInOrder();

    /**
     * Performs a preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPreOrder();

    /**
     * Performs a postorder traversal on this binary tree by calling an
     * overloaded, recursive postorder method that starts with the root.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPostOrder();

    /**
     * Performs a levelorder traversal on the binary tree, using a queue.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorLevelOrder();
}
