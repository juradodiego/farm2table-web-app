package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;
import com.ctrlaltdefeat.farmtotableconnect.service.CartService;

public class CartServiceImpl implements CartService {

    @Override
    public Cart convertToCart(List<Message> conversation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertToCart'");
    }

    @Override
    public Cart addToCart(Integer cartId, Produce produce, Integer quantity, Double price) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCart'");
    }

    @Override
    public Cart updateCart(Integer cartId, Produce produce, Integer quantity, Double price) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCart'");
    }

    @Override
    public Cart getCart(Integer cartId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCart'");
    }

    @Override
    public Cart setCart(Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCart'");
    }
    
}
