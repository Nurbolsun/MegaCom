package kg.cinematica.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(CinemaNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(RuntimeException e){
        e.printStackTrace();
        return new ResponseEntity("Системная ошибка!", HttpStatus.CONFLICT);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(DataIntegrityViolationException e){
        e.printStackTrace();
        return new ResponseEntity("Такой объект уже существует!", HttpStatus.CONFLICT);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(MovieNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(OrderDetailNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(OrderNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(PriceNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(RoomMovieNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(RoomNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(ScheduleNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(SeatScheduleNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handlerException(SeatNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
