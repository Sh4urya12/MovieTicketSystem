package com.example.Movie_Booking_System.DTOlayer;

import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SearchAndFilterDTO
{
    private String movieName;

    private String genre;

    private String language;

    @Min(value = 0, message = "Minimum price cannot be negative")
    private Double minPrice;

    @Min(value = 0, message = "Maximum price cannot be negative")
    private Double maxPrice;

    @Min(value = 1, message = "Minimum duration must be positive")
    private Integer minDuration;

    @Min(value = 1, message = "Maximum duration must be positive")
    private Integer maxDuration;

    @Min(value = 0, message = "Available seats cannot be negative")
    private Integer availableSeats;
}