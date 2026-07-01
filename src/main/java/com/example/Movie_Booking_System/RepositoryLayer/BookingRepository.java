package com.example.Movie_Booking_System.RepositoryLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
import com.example.Movie_Booking_System.ClassLayer.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>
{
List<Booking> findByUser(User user);
}

