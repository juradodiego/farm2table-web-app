package com.ctrlaltdefeat.farmtotableconnect.service;

import java.security.Timestamp;
import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

public interface ChatService {
    
    Chat getChat(Integer customerId, Integer farmerId);
    List<Message> getLatest(Integer chatId, Timestamp latestTimestamp);
    Boolean sendMessage(Message message);
    Boolean finishConversation(Integer chatId);
    Boolean isFarmerApproved(Integer chatId);
    Boolean isCustomerApproved(Integer chatId);

}
