package kg.cinematica.exceptions;

public class CinemaNotFoundException extends RuntimeException{
    public CinemaNotFoundException(String message){
        super(message);
    }
}
