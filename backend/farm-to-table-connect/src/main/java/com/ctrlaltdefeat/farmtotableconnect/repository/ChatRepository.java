package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctrlaltdefeat.farmtotableconnect.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{

}
