package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.DTOlayer.MovieRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.MovieResponseDTO;
import com.example.Movie_Booking_System.ServiceLayer.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping

    public Movie addMovie( @Valid @RequestBody MovieRequestDTO movieRequestDTO)
    {
        return movieService.addMovie(movieRequestDTO);
    }

    @GetMapping
    public List<MovieResponseDTO> getMovies()
    {
        return movieService.getMovies();
    }
}

