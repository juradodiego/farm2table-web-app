package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctrlaltdefeat.farmtotableconnect.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{

}
