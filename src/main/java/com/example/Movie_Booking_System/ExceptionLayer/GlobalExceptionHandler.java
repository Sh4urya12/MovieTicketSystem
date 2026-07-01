package com.example.Movie_Booking_System.ExceptionLayer;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleMovieNotFound(MovieNotFoundException ex)
    {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), 404, ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserNotFoundException.class)

    public ResponseEntity<ExceptionResponse> handleUserNotFound(UserNotFoundException ex)
    {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), 404, ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(SeatsNotAvailableException.class)

    public ResponseEntity<ExceptionResponse> handleSeatsNotAvailable(SeatsNotAvailableException ex)
    {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), 400, ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)

    public ResponseEntity<ExceptionResponse> handleGenericException(Exception ex)
    {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), 500, ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(MethodArgumentNotValidException ex)
    {
        Map<String,String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach
                (error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), 400, "Validation failed", fieldErrors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
