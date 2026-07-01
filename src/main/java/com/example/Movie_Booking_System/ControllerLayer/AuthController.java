package com.example.Movie_Booking_System.ControllerLayer;

import com.example.Movie_Booking_System.DTOlayer.LoginDTO;
import com.example.Movie_Booking_System.SecurityLayer.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/auth")

public class AuthController
{
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")

    public String login(@RequestBody LoginDTO loginDTO)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        return jwtUtil.generateToken(loginDTO.getEmail());
    }
}

