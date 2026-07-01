package com.example.Movie_Booking_System.SecurityLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.RepositoryLayer.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail(email);

        if(user == null)
        {
            throw new UsernameNotFoundException("User Not Found");
        }

        return new org.springframework.security.core.userdetails.User( user.getEmail(), user.getPass(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())) );
    }
}

