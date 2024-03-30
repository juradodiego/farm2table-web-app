package com.ctrlaltdefeat.farmtotableconnect.service;

import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.CartItem;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface CartService {

    /**
     * Converts current conversation into a cart object using ChatGPT API
     * @param conversation - List of Message from Chat object
     * @return Cart object
     */
    Cart convertToCart(List<Message> conversation);
    Cart addToCart(Integer cartId, CartItem cartItem);
    Cart updateCart(Integer cartId, CartItem cartItem);
    Cart getCart(Integer cartId);
    Cart setCart(Cart cart);
    Boolean isFarmerApproved(Integer chatId);
    Boolean isCustomerApproved(Integer chatId);
}
