package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.DTOlayer.BookingDTO;
import com.example.Movie_Booking_System.DTOlayer.EmailDTO;
import com.example.Movie_Booking_System.ExceptionLayer.MovieNotFoundException;
import com.example.Movie_Booking_System.ExceptionLayer.SeatsNotAvailableException;
import com.example.Movie_Booking_System.ExceptionLayer.UserNotFoundException;
import com.example.Movie_Booking_System.RepositoryLayer.BookingRepository;
import com.example.Movie_Booking_System.RepositoryLayer.MovieRepository;
import com.example.Movie_Booking_System.RepositoryLayer.UserRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service

public class BookingService
{
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;


    public EmailDTO bookTicket(BookingDTO bookingDTO)
    {
        User user = userRepository.findById(bookingDTO.getUserId()).orElse(null);
        Movie movie = movieRepository.findById(bookingDTO.getMovieId()).orElse(null);

        if(user == null)
        {
            throw new UserNotFoundException("User Not Found");
        }

        if(movie == null)
        {
            throw new MovieNotFoundException("Movie Not Found");
        }

        if(movie.getAvailableSeats() < bookingDTO.getSeatsRequested())
        {
            throw new SeatsNotAvailableException("Seats Not Available");
        }

        movie.setAvailableSeats(movie.getAvailableSeats() - bookingDTO.getSeatsRequested());
        movieRepository.save(movie);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovie(movie);
        booking.setSeatsBooked(bookingDTO.getSeatsRequested());
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount(bookingDTO.getSeatsRequested() * movie.getTicketPrice());
        bookingRepository.save(booking);
        String subject = "Movie Ticket Booked";

        String body = "Your ticket has been booked successfully.\n\n"
                + "Movie: " + movie.getMovieName()
                + "\nSeats Booked: " + bookingDTO.getSeatsRequested()
                + "\nTotal Amount: " + booking.getTotalAmount();

        return new EmailDTO(user.getEmail(), subject, body);
    }

    public List<Booking> getBookings()
    {
        return bookingRepository.findAll();
    }

}

