package com.example.Movie_Booking_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.*;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class MovieBookingSystemApplication
{
	public static void main(String[] args) {
		SpringApplication.run(MovieBookingSystemApplication.class, args);
	}

}
