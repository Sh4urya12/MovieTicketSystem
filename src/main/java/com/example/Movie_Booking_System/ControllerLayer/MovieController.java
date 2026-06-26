package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.ServiceLayer.MovieService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {

        return movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getMovies() {

        return movieService.getMovies();
    }

}

