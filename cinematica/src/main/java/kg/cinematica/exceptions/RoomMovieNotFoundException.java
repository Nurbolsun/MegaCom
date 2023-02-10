package kg.cinematica.exceptions;

public class RoomMovieNotFoundException extends RuntimeException{
    public RoomMovieNotFoundException(String message) {
        super(message);
    }
}
