package com.example.demo.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExeptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExeptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> HandleBusiness(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> HandleNotFound(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> HandleUnexpected(Throwable unexpectedExeption) {
        var message = "Unexpected server error, see the logs.";
        logger.error(message, unexpectedExeption);
        return new ResponseEntity<>("Unexpected server error, see the logs.", HttpStatus.NOT_FOUND);
    }    
}
