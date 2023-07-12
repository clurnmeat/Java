package com.devmountain.RadRecipeMaker.services;

import com.devmountain.RadRecipeMaker.dtos.UserDto;
import com.devmountain.RadRecipeMaker.entities.User;
import com.devmountain.RadRecipeMaker.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("User added Successfully");
        return response;
    }

    @NotNull
    @Override
    @Transactional
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("Log-in Successful");
            } else {
                response.add("Username or Password is incorrect");
            }
        } else {
            response.add("Username or Password is incorrect");
        }
        return  response;

    }
}
