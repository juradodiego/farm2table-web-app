package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrlaltdefeat.farmtotableconnect.model.User;

public class CustomUserRepositoryImpl implements CustomUserRepository{

    private final UserRepository userRepository;

    @Autowired
    public CustomUserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String email) {
        List<User> matchingUsers = userRepository.findAll().stream().filter(u -> u.getEmail().equals(email)).toList();
        return matchingUsers.isEmpty() ? null : matchingUsers.get(0);
    }
    
}
