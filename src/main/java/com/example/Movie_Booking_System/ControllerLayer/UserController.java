package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.DTOlayer.UserDTO;
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

    @PostMapping("/users")
    public User addUser(@RequestBody UserDTO userDTO)
    {
        return userService.addUser(userDTO);
    }
    
    @GetMapping
    public List<User> getUsers()
    {
        return userService.getUsers();
    }
}
