package pzn.belajarspringwebmvc.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//learn manipulate error message with annotation @ControlAdvice

@ControllerAdvice
public class ErrorController {

    //we can use @ExceptionHandler to make controller to handle error that we want to capture

    //so this is the error handler for Method Argument Not Valid Exception:
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        //we can return what the message, and the status
        return new ResponseEntity<>("Validation Error : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //this is example of handler for Constraint Violation Exception:
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<>("Validation Error : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
