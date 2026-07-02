package com.example.Movie_Booking_System.RepositoryLayer;

import com.example.Movie_Booking_System.ClassLayer.Movie;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie>
{

}
