package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
import com.example.Movie_Booking_System.ClassLayer.Movie;
import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.DTOlayer.BookingRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.BookingResponseDTO;
import com.example.Movie_Booking_System.DTOlayer.EmailDTO;
import com.example.Movie_Booking_System.ExceptionLayer.MovieNotFoundException;
import com.example.Movie_Booking_System.ExceptionLayer.SeatsNotAvailableException;
import com.example.Movie_Booking_System.ExceptionLayer.UserNotFoundException;
import com.example.Movie_Booking_System.RepositoryLayer.BookingRepository;
import com.example.Movie_Booking_System.RepositoryLayer.MovieRepository;
import com.example.Movie_Booking_System.RepositoryLayer.UserRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    public EmailDTO bookTicket(BookingRequestDTO bookingRequestDTO)
    {
        User user = userRepository.findById(bookingRequestDTO.getUserId()).orElse(null);
        Movie movie = movieRepository.findById(bookingRequestDTO.getMovieId()).orElse(null);

        if(user == null)
        {
            throw new UserNotFoundException("User Not Found");
        }

        if(movie == null)
        {
            throw new MovieNotFoundException("Movie Not Found");
        }

        if(movie.getAvailableSeats() < bookingRequestDTO.getSeatsRequested())
        {
            throw new SeatsNotAvailableException("Seats Not Available");
        }

        movie.setAvailableSeats(movie.getAvailableSeats() - bookingRequestDTO.getSeatsRequested());
        movieRepository.save(movie);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovie(movie);
        booking.setSeatsBooked(bookingRequestDTO.getSeatsRequested());
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount(bookingRequestDTO.getSeatsRequested() * movie.getTicketPrice());
        bookingRepository.save(booking);
        String subject = "Movie Ticket Booked";

        String body = "Your ticket has been booked successfully.\n\n"
                + "Movie: " + movie.getMovieName()
                + "\nSeats Booked: " + bookingRequestDTO.getSeatsRequested()
                + "\nTotal Amount: " + booking.getTotalAmount();

        return new EmailDTO(user.getEmail(), subject, body);
    }

    public List getBookings()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email);

        List<Booking> bookings;

        if(user.getRole().equals("ADMIN"))
        {
            bookings = bookingRepository.findAll();
        }
        else
        {
            bookings = bookingRepository.findByUser(user);
        }

        List<BookingResponseDTO> response = new ArrayList<>();
        for(Booking booking : bookings)
        {
            BookingResponseDTO dto = new BookingResponseDTO(
                    booking.getId(),
                    booking.getUser().getName(),
                    booking.getMovie().getMovieName(),
                    booking.getSeatsBooked(),
                    booking.getTotalAmount(),
                    booking.getBookingTime()
                    );
            response.add(dto);
        }
        return response;
    }
}



