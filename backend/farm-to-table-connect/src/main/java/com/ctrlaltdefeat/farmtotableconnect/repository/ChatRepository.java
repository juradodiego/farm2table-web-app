package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
    
    @Query()
    Optional<Chat> getChat(Integer customerId, Integer farmerId);

    @Query()
    Optional<List<Message>> getLatestMessages(Integer chatId, Timestamp lastTimestamp);

    @Query()
    Optional<Boolean> sendMessage(Message message);

    @Query()
    Optional<List<Chat>> getAllChats(Integer userId);
    
}
