package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.repository.ChatRepository;
import com.ctrlaltdefeat.farmtotableconnect.service.CartService;
import com.ctrlaltdefeat.farmtotableconnect.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    CartService cartService;

    @Override
    public Chat getChat(Integer customerId, Integer farmerId) {
        List<Chat> matchingChats = chatRepository.findAll().stream()
        .filter(c -> c.getFarmerId().equals(farmerId) && c.getCustomerId().equals(customerId))
        .toList();

        return matchingChats.isEmpty() ? null : matchingChats.get(0);

    }

    @Override
    public List<Message> getLatest(Integer chatId, Timestamp latestTimestamp) {
        return chatRepository.findById(chatId).orElseThrow().getConversation().stream().filter(m -> m.getSentAt().after(latestTimestamp)).toList();
    }

    @Override
    public Chat sendMessage(Message message) {
        Chat chat = chatRepository.findById(message.getChatId()).orElseThrow();
        chat.getConversation().add(message);
       return chatRepository.save(chat);
    }

    @Override
    public Cart finishConversation(Integer chatId) {
        List<Message> conversation = chatRepository.findById(chatId).orElseThrow().getConversation();
        return cartService.convertToCart(conversation);
        
    }

    
    
}
