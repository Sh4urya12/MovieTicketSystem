package com.example.Movie_Booking_System.ClassLayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String pass;
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
}
