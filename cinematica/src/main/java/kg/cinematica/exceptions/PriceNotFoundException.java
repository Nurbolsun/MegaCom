package kg.cinematica.exceptions;

public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException(String message) {
        super(message);
    }
}
