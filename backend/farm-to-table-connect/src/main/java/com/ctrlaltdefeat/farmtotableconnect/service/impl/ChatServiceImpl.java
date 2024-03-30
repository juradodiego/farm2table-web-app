package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;
import com.ctrlaltdefeat.farmtotableconnect.service.ChatService;

public class ChatServiceImpl implements ChatService {

    @Override
    public Chat getChat(Integer customerId, Integer farmerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChat'");
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
