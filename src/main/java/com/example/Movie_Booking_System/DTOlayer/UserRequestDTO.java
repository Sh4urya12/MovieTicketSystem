package com.example.Movie_Booking_System.DTOlayer;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRequestDTO
{
    private String name;
    private String phone;
    private String email;
    private String pass;
}

