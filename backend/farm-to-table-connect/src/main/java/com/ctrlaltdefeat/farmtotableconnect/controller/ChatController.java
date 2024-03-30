package com.ctrlaltdefeat.farmtotableconnect.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltdefeat.farmtotableconnect.service.ChatService;
import com.ctrlaltdefeat.farmtotableconnect.service.UserService;
import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Cart;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.aspectj.apache.bcel.classfile.Module.Open;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.List;




@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/chat")
public class ChatController {
    
    @Autowired
    private ChatService chatService;
    
    @GetMapping("/get")
    public Chat getChat(@RequestParam Integer customerId, Integer farmerId) {
        Chat chat = chatService.getChat(customerId, farmerId);
        if (chat == null) {
            throw new Exception("No correspdonding messages with farmerId/ccustomerId");
        }
        return chat;
    }

    @GetMapping("/latest")
    public List<Message> getLatest(@RequestParam Integer chatId, Timestamp latestTimestamp) {
        List<Message> chat = chatService.getLatest(chatId, latestTimestamp);
        if (chat == null) {
            throw new Exception("No messages");
        }
        return chat;
    }
    
    @PostMapping("/send")
    public Chat sendMessage(@RequestBody Message message) {
        Chat chat = chatService.sendMessage(message);
        if (chat == null) {
            throw new Exception("Cannot send message");
        }
        return chat;
    }

    @PostMapping("/end")
    public Cart finishConveration(@RequestBody Integer chatId) {
        Cart cart = chatService.finishConversation(chatId);
        if (cart == null) {
            throw new Exception("Cannot finish conversation");
        }
        
        return cart;
    }
}
