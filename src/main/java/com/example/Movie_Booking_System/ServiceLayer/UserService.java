package com.example.Movie_Booking_System.ServiceLayer;

import com.example.Movie_Booking_System.ClassLayer.User;
import com.example.Movie_Booking_System.DTOlayer.UserRequestDTO;
import com.example.Movie_Booking_System.DTOlayer.UserResponseDTO;
import com.example.Movie_Booking_System.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public User addUser(UserRequestDTO userRequestDTO)
    {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPass(passwordEncoder.encode( userRequestDTO.getPass() ));
        user.setPhone(userRequestDTO.getPhone());
        user.setRole("USER");
        return userRepository.save(user);
    }

    public List<UserResponseDTO> getUsers()
    {
        List<User> users = userRepository.findAll();

        List<UserResponseDTO> response = new ArrayList<>();

        for(User user : users)
        {
            UserResponseDTO dto = new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getRole()
            );
            response.add(dto);
        }
        return response;
    }
}
