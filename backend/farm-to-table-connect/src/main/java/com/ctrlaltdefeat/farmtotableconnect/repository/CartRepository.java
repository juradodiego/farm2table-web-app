package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    
}
