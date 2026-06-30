package com.example.Movie_Booking_System.ExceptionLayer;

import lombok.*;
import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExceptionResponse
{
    private LocalDateTime timestamp;
    private Integer status;
    private String message;
}
