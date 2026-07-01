package com.example.Movie_Booking_System.RepositoryLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

    User findByEmail(String email);
}
