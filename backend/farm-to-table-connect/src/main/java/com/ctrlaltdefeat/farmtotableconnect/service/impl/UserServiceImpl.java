package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ctrlaltdefeat.farmtotableconnect.model.User;
import com.ctrlaltdefeat.farmtotableconnect.repository.UserRepository;
import com.ctrlaltdefeat.farmtotableconnect.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserByUsername(String email, String password) {
        Optional<User> response = userRepository.getUserByUsername(email);
        if (response.isPresent()) {
            return response.get();
            
        }
        return null;
       
    }

    @Override
    public User getUserByUserId(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByUserId'");
    }

    @Override
    public User newUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newUser'");
    }
    
    private String encodePassword(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

}
