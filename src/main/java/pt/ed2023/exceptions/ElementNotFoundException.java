/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.exceptions;

/**
 *
 * @author 8200335
 */
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message) {
        super("Erro " + message);
    }
}
