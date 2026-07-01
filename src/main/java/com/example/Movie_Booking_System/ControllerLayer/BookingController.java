package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
import com.example.Movie_Booking_System.DTOlayer.BookingRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.BookingResponseDTO;
import com.example.Movie_Booking_System.DTOlayer.EmailDTO;
import com.example.Movie_Booking_System.ServiceLayer.BookingService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bookings")

public class BookingController
{
    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public EmailDTO bookTicket(@RequestBody BookingRequestDTO bookingRequestDTO)
    {
        return bookingService.bookTicket(bookingRequestDTO);
    }

    @GetMapping
    public List<BookingResponseDTO> getBookings()
    {
        return bookingService.getBookings();
    }
}

