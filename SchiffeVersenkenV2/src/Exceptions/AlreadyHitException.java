package Exceptions;

public class AlreadyHitException extends Throwable {

    public AlreadyHitException(){
        super("Dieses Feld wurde bereits beschossen");
    }
}
