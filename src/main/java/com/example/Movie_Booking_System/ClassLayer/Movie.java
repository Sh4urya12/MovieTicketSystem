package com.example.Movie_Booking_System.ClassLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String movieName;
    private String genre;
    private Integer duration;
    private String language;
    private Integer availableSeats;
    private Double ticketPrice;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Booking> bookings;
}

