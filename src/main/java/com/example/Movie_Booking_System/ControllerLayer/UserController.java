package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.DTOlayer.UserRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.UserResponseDTO;
import com.example.Movie_Booking_System.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        return userService.addUser(userRequestDTO);
    }

    @GetMapping
    public List<UserResponseDTO> getUsers()
    {
        return userService.getUsers();
    }
}
