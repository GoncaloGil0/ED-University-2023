/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.exceptions;

/**
 * Excepção de caminho desconhecido
 *
 * @author 8200335
 */
public class UnknownPathException extends Exception {

    public UnknownPathException() {
        super();
    }

    public UnknownPathException(String message) {
        super(message);
    }
}
