package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.DTOlayer.UserDTO;
import com.example.Movie_Booking_System.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public User addUser(UserDTO userDTO)
    {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPass(userDTO.getPass());
        user.setPhone(userDTO.getPhone());
        return userRepository.save(user);
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
