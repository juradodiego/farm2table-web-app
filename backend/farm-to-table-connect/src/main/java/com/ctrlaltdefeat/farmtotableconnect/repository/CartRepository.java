package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

    @Query()
    Cart getCart(Integer cartId);
    
    @Query()
    Boolean setCart(Cart cart);
    
}
