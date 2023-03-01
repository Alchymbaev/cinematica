package kg.megacom.cinematica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(RuntimeException e){
        return new ResponseEntity("System error!", HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(CinemaException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(MovieException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(OrderDetailException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(OrderException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(PriceException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(RoomException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(RoomMovieException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(RoomMoviePriceException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(ScheduleException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(SeatException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(SeatScheduleException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
