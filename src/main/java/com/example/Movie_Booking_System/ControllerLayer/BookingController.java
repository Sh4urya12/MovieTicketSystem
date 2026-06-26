package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
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

    @PostMapping
    public String bookTicket(@RequestParam  Integer userId, @RequestParam Integer movieId, @RequestParam Integer seatsRequested)
    {
        return bookingService.bookTicket
                (
                userId,
                movieId,
                seatsRequested
        );
    }

    @GetMapping
    public List<Booking> getBookings()
    {
        return bookingService.getBookings();
    }

}

