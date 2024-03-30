package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctrlaltdefeat.farmtotableconnect.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query(value = "SELECT * FROM getUserByUsername(?1)", nativeQuery = true)
    Optional<User> getUserByUsername(String email);

    @Query(value = "SELECT * FROM getUserByUserId(?1)", nativeQuery = true)
    Optional<User> getUserByUserId(Integer userId);

    @Query(value = "SELECT * FROM newUser(?1)", nativeQuery = true)
    Optional<Boolean> newUser(User user);

}
