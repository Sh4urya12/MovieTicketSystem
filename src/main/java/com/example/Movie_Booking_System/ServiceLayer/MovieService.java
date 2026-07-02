package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.DTOlayer.MovieRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.MovieResponseDTO;
import com.example.Movie_Booking_System.DTOlayer.SearchAndFilterDTO;
import com.example.Movie_Booking_System.RepositoryLayer.MovieRepository;
import com.example.Movie_Booking_System.SpecificationLayer.MovieSpecification;
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

    @Caching(evict = {@CacheEvict(value = "movies", allEntries = true),
            @CacheEvict(value = "movieSearchResults", allEntries = true)})
    public MovieResponseDTO addMovie(MovieRequestDTO movieRequestDTO)
    {
        Movie movie = new Movie();
        movie.setMovieName(movieRequestDTO.getMovieName());
        movie.setGenre(movieRequestDTO.getGenre());
        movie.setDuration(movieRequestDTO.getDuration());
        movie.setLanguage(movieRequestDTO.getLanguage());
        movie.setAvailableSeats(movieRequestDTO.getAvailableSeats());
        movie.setTicketPrice(movieRequestDTO.getTicketPrice());

        Movie savedMovie = movieRepository.save(movie);

        return new MovieResponseDTO(
                savedMovie.getId(),
                savedMovie.getMovieName(),
                savedMovie.getGenre(),
                savedMovie.getDuration(),
                savedMovie.getLanguage(),
                savedMovie.getAvailableSeats(),
                savedMovie.getTicketPrice()
        );
    }

    @Cacheable ("movies")
    public List<MovieResponseDTO> getMovies()
    {
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponseDTO> response = new ArrayList<>();

        for(Movie movie : movies)
        {
            MovieResponseDTO movieDTO = new MovieResponseDTO
                    (
                            movie.getId(),
                            movie.getMovieName(),
                            movie.getGenre(),
                            movie.getDuration(),
                            movie.getLanguage(),
                            movie.getAvailableSeats(),
                            movie.getTicketPrice()
                    );
            response.add(movieDTO);
        }
        return response;
    }

    @Cacheable("movieSearchResults")
    public List<MovieResponseDTO> searchMovies(SearchAndFilterDTO dto)
    {
        List<Movie> movies = movieRepository.findAll(MovieSpecification.filterMovies(dto));
        List<MovieResponseDTO> response = new ArrayList<>();

        for(Movie movie : movies)
        {
            MovieResponseDTO movieDTO = new MovieResponseDTO
                    (
                            movie.getId(),
                            movie.getMovieName(),
                            movie.getGenre(),
                            movie.getDuration(),
                            movie.getLanguage(),
                            movie.getAvailableSeats(),
                            movie.getTicketPrice()
                    );

            response.add(movieDTO);
        }
        return response;
    }


}


