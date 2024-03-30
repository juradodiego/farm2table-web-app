package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.security.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
    
    @Query()
    Chat getChat(Integer customerId, Integer farmerId);

    @Query()
    List<Message> getLatestMessages(Integer chatId, Timestamp lastTimestamp);

    @Query()
    Boolean sendMessage(Message message);

    @Query()
    List<Chat> getAllChats(Integer userId);
    
}
