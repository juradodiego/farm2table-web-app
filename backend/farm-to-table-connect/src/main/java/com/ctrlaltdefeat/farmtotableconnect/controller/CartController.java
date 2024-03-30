package com.ctrlaltdefeat.farmtotableconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.CartItem;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;
import com.ctrlaltdefeat.farmtotableconnect.service.CartService;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

     @PostMapping("/getCart")
    public Cart getCart(int cartID) throws Exception {
        try {
            Cart cart = cartService.getCart(cartID);
            // TODO: Make custom exception
            if (cart == null) 
                throw new Exception("Cart doesn't exist");
            return cart;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }

     @PostMapping("/update")
    public Cart updateCart(Integer cartID, CartItem cartItem) throws Exception {
        try {
            Cart cart = cartService.updateCart(cartID, cartItem);
            // TODO: Make custom exception
            if (cart == null) 
                throw new Exception("Cart doesn't exist");
            return cart;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }
    
     @PostMapping("/add")
    public Cart addToCart(Integer cartId, CartItem cartItem) throws Exception {
        try {
            Cart cart = cartService.addToCart(cartId, cartItem);
            // TODO: Make custom exception
            if (cart == null) 
                throw new Exception("Cart doesn't exist");
            return cart;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }

     @PostMapping("/new")
    public Cart newCart(List<Message> conversation) throws Exception {
        try {
            Cart cart = cartService.convertToCart(conversation);
            // TODO: Make custom exception
            if (cart == null) 
                throw new Exception("Cart cannot be created");
            return cart;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }
}
