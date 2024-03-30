package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.Optional;

import com.ctrlaltdefeat.farmtotableconnect.model.User;

public interface CustomUserRepository {
    // @Query(value= "select u FROM users u where u.email = ?1", nativeQuery = true )
    User getUserByUsername(String email);

    // @Query(value = "SELECT * FROM getUserByUserId(?1)", nativeQuery = true)
    // Optional<User> getUserByUserId(Integer userId);

    // @Query(value = "SELECT * FROM newUser(?1)", nativeQuery = true)
    // Optional<Boolean> newUser(User user);


}
