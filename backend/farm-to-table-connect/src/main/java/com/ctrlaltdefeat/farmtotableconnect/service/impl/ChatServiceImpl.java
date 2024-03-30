package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.repository.ChatRepository;
import com.ctrlaltdefeat.farmtotableconnect.repository.FarmRepository;
import com.ctrlaltdefeat.farmtotableconnect.repository.UserRepository;
import com.ctrlaltdefeat.farmtotableconnect.service.ChatService;

public class ChatServiceImpl implements ChatService {

    @Autowired
    UserRepository userRepository;

    
    @Autowired
    FarmRepository farmRepository;

    
    @Autowired
    ChatRepository chatRepository;

    @Override
    public Chat getChat(Integer customerId, Integer farmerId) {
        Optional<Chat> response = chatRepository.getChat(customerId, farmerId);
        if (response.isPresent()) {
            
        }
    }

    @Override
    public List<Message> getLatest(Integer chatId, Timestamp latestTimestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLatest'");
    }

    @Override
    public Boolean sendMessage(Message message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendMessage'");
    }

    @Override
    public Boolean finishConversation(Integer chatId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishConversation'");
    }

    @Override
    public Boolean isFarmerApproved(Integer chatId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFarmerApproved'");
    }

    @Override
    public Boolean isCustomerApproved(Integer chatId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCustomerApproved'");
    }
    
}
