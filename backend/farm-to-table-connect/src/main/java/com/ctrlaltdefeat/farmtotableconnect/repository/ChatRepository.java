package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{
    
    @Query(value = "select * from getChat(?1, ?2)", nativeQuery = true)
    Optional<Chat> getChat(Integer customerId, Integer farmerId);

    @Query(value = "select * from getLatestMessages(?1, ?2)", nativeQuery = true)
    Optional<List<Message>> getLatestMessages(Integer chatId, Timestamp lastTimestamp);

    @Query(value = "select * from sendMessage(?1)", nativeQuery = true)
    Optional<Boolean> sendMessage(Message message);

    @Query(value = "select * from getAllChats(?1)", nativeQuery = true)
    Optional<List<Chat>> getAllChats(Integer userId);

    @Query(value = "select * from isFarmerApproved(?1)", nativeQuery = true)
    Optional<Boolean> isFarmerApproved(Integer chatId);

    @Query(value = "select * from isCustomerApproved(?1)", nativeQuery = true)
    Optional<Boolean> isCustomerApproved(Integer chatId);
    
}
