package com.example.Movie_Booking_System.ExceptionLayer;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice

public class GlobalExceptionHandler
{
    @ExceptionHandler(MovieNotFoundException.class)

    public String handleMovieNotFound(MovieNotFoundException ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)

    public String handleUserNotFound(UserNotFoundException ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler (SeatsNotAvailableException.class)

    public String handleSeatsNotAvailable(SeatsNotAvailableException ex)
    {
        return ex.getMessage();
    }
}
