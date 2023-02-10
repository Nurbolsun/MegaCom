package kg.cinematica.exceptions;

public class SeatNotFoundException extends RuntimeException{
    public SeatNotFoundException(String message) {
        super(message);
    }
}
