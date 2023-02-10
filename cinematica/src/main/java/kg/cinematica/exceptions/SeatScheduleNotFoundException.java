package kg.cinematica.exceptions;

public class SeatScheduleNotFoundException extends RuntimeException{
    public SeatScheduleNotFoundException(String message) {
        super(message);
    }
}
