package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
