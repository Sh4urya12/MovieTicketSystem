package com.example.Movie_Booking_System.RepositoryLayer;

import com.example.Movie_Booking_System.ClassLayer.Booking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>
{

}

