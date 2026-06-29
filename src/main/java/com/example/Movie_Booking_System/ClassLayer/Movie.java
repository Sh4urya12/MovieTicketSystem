package com.example.Movie_Booking_System.ClassLayer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "movie")
    private List<Booking> bookings;
}

