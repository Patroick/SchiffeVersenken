package Exceptions;

/**
 * Exception für Ungültide Indexe
 */

public class InvalidIndexException extends Throwable {

    /**
     * Konstruktor
     */
    public InvalidIndexException(){
        super("Ungültige Koordinate!");
    }
}
