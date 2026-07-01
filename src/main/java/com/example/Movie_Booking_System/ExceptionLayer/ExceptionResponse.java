package com.example.Movie_Booking_System.ExceptionLayer;

import lombok.*;
import java.time.*;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExceptionResponse
{
    public ExceptionResponse(LocalDateTime timestamp, Integer status, String message)
    {
        this(timestamp, status, message, null);
    }

    private LocalDateTime timestamp;

    private Integer status;

    private String message;

    private Map<String, String> errors;
}
