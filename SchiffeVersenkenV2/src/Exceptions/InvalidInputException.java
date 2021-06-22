package Exceptions;

/**
 * Exception für Ungültigen Input
 */

public class InvalidInputException extends Exception {

    /**
     * Konstruktor
     */
    public InvalidInputException(){
        super("Der eingegebene Input ist ungültig");
    }
}
