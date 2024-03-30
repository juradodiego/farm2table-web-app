package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctrlaltdefeat.farmtotableconnect.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
}
