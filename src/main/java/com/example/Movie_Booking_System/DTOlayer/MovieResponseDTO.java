package com.example.Movie_Booking_System.DTOlayer;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MovieResponseDTO {
    private Integer id;
    private String movieName;
    private String genre;
    private Integer duration;
    private String language;
    private Integer availableSeats;
    private Double ticketPrice;
}
