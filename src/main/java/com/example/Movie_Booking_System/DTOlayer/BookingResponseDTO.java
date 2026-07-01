package com.example.Movie_Booking_System.DTOlayer;

import lombok.*;

import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingResponseDTO
{
    private Integer bookingId;
    private String userName;
    private String movieName;
    private Integer seatsBooked;
    private Double totalAmount;
    private LocalDateTime bookingTime;
}