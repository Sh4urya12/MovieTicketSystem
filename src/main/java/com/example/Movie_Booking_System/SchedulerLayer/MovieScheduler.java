package com.example.Movie_Booking_System.SchedulerLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.RepositoryLayer.MovieRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;

@Component
public class MovieScheduler
{
    @Autowired
    MovieRepository movieRepository;

    @Scheduled(fixedRate = 60000)

    public void checkMovies()
    {
        List<Movie> movies = movieRepository.findAll();
        System.out.println("-----MOVIE STATUS-----");
        for(Movie movie : movies)
        {
            System.out.println( movie.getMovieName() + " -> Seats Left: " + movie.getAvailableSeats());
        }
        System.out.println("----------------------");
    }

}
