package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.stereotype.Repository;

import com.ctrlaltdefeat.farmtotableconnect.model.User;

@Repository
public interface CustomUserRepository {
    public User getUserByID(Integer userID);
    public User getUserByName(String username);
    public User createNewUser(User user);
}
