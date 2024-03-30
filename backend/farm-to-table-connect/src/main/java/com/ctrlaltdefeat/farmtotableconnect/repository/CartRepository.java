package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

    // @Query()
    // Optional<Cart> getCart(Integer cartId);

    // @Query()
    // Optional<Boolean> setCart(Cart cart);
    
}
