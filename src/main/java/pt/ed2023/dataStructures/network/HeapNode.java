/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.network;

/**
 *
 * @author 8200335
 * @param <T>
 */
public class HeapNode<T> extends BinaryTreeNode<T> {
    protected HeapNode<T> parent;
    
    /**
     * Creates a new heap node with the specified data
     * @param obj the data to be contained within the new heap nodes
     * 
     */
    public HeapNode(T obj) {
        super(obj);
        this.parent = null;
    }

    public HeapNode<T> getParent() {
        return parent;
    }

    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }    
}
