package com.example.Movie_Booking_System.DTOlayer;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MovieRequestDTO
{
    @NotBlank(message = "Movie name cannot be empty")
    private String movieName;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @Min(value = 1, message = "Duration must be greater than 0")
    private Integer duration;

    @NotBlank(message = "Language cannot be empty")
    private String language;

    @Min(value = 1, message = "Available seats must be greater than 0")
    private Integer availableSeats;

    @Min(value = 1, message = "Ticket price must be greater than 0")
    private Double ticketPrice;
}
