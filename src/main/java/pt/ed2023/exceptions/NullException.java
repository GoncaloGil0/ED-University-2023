/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.exceptions;

/**
 * Excepção de output null
 *
 * @author 8200335
 */
public class NullException extends Exception {

    public NullException(String message) {
        super("Erro " + message);
    }
}
