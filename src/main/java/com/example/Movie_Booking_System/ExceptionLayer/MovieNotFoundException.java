package com.example.Movie_Booking_System.ExceptionLayer;

public class MovieNotFoundException extends RuntimeException
{
    public MovieNotFoundException(String message)
    {
        super(message);
    }

}

