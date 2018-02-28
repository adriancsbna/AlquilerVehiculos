/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Rober
 */
public class FormatoIncorrectoException extends Exception{

    public FormatoIncorrectoException() {
        super("Formato de los caracteres incorrecto (no es un carácter del alfabeto inglés)");
    }

    public FormatoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
