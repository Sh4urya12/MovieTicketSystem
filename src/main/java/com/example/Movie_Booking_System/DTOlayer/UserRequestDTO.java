package com.example.Movie_Booking_System.DTOlayer;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRequestDTO
{
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Size(min = 4, message = "Password must be minimum 4 characters")
    private String pass;
}

