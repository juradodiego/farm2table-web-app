package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctrlaltdefeat.farmtotableconnect.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository{
    
  
}
