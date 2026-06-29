package com.example.Movie_Booking_System.ExceptionLayer;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
