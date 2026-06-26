package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.ClassLayer.User;
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

    public String bookTicket(Integer userId, Integer movieId, Integer seatsRequested)
    {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if(user == null)
        {
            return "User Not Found";
        }

        if(movie == null)
        {
            return "Movie Not Found";
        }

        if(movie.getAvailableSeats() < seatsRequested)
        {
            return "Seats Not Available";
        }

        movie.setAvailableSeats( movie.getAvailableSeats() - seatsRequested );

        movieRepository.save(movie);
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovie(movie);
        booking.setSeatsBooked(seatsRequested);
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount( seatsRequested * movie.getTicketPrice() );

        bookingRepository.save(booking);
        return "Ticket Booked Successfully";
    }

    public List<Booking> getBookings()
    {
        return bookingRepository.findAll();
    }

}

