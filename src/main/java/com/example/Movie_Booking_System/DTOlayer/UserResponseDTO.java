package com.example.Movie_Booking_System.DTOlayer;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String role;
}
