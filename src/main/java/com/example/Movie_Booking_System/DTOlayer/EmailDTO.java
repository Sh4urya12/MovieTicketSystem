package com.example.Movie_Booking_System.DTOlayer;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmailDTO
{
    private String toEmail;
    private String subject;
    private String body;
}
