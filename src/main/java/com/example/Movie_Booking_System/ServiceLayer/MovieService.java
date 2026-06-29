package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.DTOlayer.MovieDTO;
import com.example.Movie_Booking_System.RepositoryLayer.MovieRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class MovieService
{
    @Autowired
    MovieRepository movieRepository;

    public Movie addMovie(MovieDTO movieDTO)
    {
        Movie movie = new Movie();
        movie.setMovieName(movieDTO.getMovieName());
        movie.setGenre(movieDTO.getGenre());
        movie.setDuration(movieDTO.getDuration());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setAvailableSeats(movieDTO.getAvailableSeats());
        movie.setTicketPrice(movieDTO.getTicketPrice());
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies()
    {
        return movieRepository.findAll();
    }
}
