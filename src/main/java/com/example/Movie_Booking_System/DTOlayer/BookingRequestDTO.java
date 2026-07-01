package com.example.Movie_Booking_System.DTOlayer;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingRequestDTO
{
    @NotNull(message = "User ID required")
    private Integer userId;

    @NotNull(message = "Movie ID required")
    private Integer movieId;

    @Min(value = 1, message = "Seats must be at least 1")
    private Integer seatsRequested;
}
