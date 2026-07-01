package com.example.Movie_Booking_System.DTOlayer;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingRequestDTO
{
    private Integer userId;
    private Integer movieId;
    private Integer seatsRequested;
}
