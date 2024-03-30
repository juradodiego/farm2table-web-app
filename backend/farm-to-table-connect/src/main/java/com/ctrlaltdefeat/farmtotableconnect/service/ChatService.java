package com.ctrlaltdefeat.farmtotableconnect.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

public interface ChatService {
    
    Chat getChat(Integer customerId, Integer farmerId);
    List<Message> getLatest(Integer chatId, Timestamp latestTimestamp);
    Chat sendMessage(Message message);
    Cart finishConversation(Integer chatId);
    

}
