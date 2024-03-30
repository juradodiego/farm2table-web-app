package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.CartItem;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;
import com.ctrlaltdefeat.farmtotableconnect.repository.CartRepository;
import com.ctrlaltdefeat.farmtotableconnect.service.CartService;

public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart convertToCart(List<Message> conversation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertToCart'");
    }

    @Override
    public Cart addToCart(Integer cartId, CartItem cartItem) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        if (cart.getContent().stream().filter(i -> i.getProduceId().equals(cartItem.getCartItemId())).count() > 0) updateCart(cartId, cartItem);
        cart.getContent().add(cartItem);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Integer cartId, CartItem cartItem) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        cart.getContent().stream()
            .filter(i -> i.getProduceId().equals(cartItem.getCartItemId()))
            .forEach(i -> { 
                i.setQuantity(cartItem.getQuantity()); 
                i.setPrice(cartItem.getPrice());
            });
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Integer cartId) {
       return cartRepository.findById(cartId).orElseThrow();
    }

    @Override
    public Cart setCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Boolean isFarmerApproved(Integer chatId) {
       return cartRepository.findById(chatId).orElseThrow().getApprovedByFarmer();
    }

    @Override
    public Boolean isCustomerApproved(Integer chatId) {
        return cartRepository.findById(chatId).orElseThrow().getApprovedByCustomer();
    }
    
}
