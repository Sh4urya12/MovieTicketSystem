package com.example.Movie_Booking_System.ExceptionLayer;

public class SeatsNotAvailableException extends RuntimeException
{
    public SeatsNotAvailableException(String message)
    {
        super(message);
    }
}

