package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.DTOlayer.MovieRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.MovieResponseDTO;
import com.example.Movie_Booking_System.RepositoryLayer.MovieRepository;
import org.springframework.cache.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService
{
    @Autowired
    MovieRepository movieRepository;

    @CacheEvict(value = "movies", allEntries = true)

    public Movie addMovie(MovieRequestDTO movieRequestDTO)
    {
        Movie movie = new Movie();
        movie.setMovieName(movieRequestDTO.getMovieName());
        movie.setGenre(movieRequestDTO.getGenre());
        movie.setDuration(movieRequestDTO.getDuration());
        movie.setLanguage(movieRequestDTO.getLanguage());
        movie.setAvailableSeats(movieRequestDTO.getAvailableSeats());
        movie.setTicketPrice(movieRequestDTO.getTicketPrice());
        return movieRepository.save(movie);
    }
    @Cacheable ("movies")

    public List<MovieResponseDTO> getMovies()
    {
        List<Movie> movies = movieRepository.findAll();

        List<MovieResponseDTO> response = new ArrayList<>();

        for(Movie movie : movies)
        {

            MovieResponseDTO dto = new MovieResponseDTO(
                    movie.getId(),
                    movie.getMovieName(),
                    movie.getGenre(),
                    movie.getDuration(),
                    movie.getLanguage(),
                    movie.getAvailableSeats(),
                    movie.getTicketPrice()
                    );
            response.add(dto);
        }
        return response;
    }
}


