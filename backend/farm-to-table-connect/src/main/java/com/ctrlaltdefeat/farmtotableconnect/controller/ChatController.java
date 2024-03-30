package com.ctrlaltdefeat.farmtotableconnect.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltdefeat.farmtotableconnect.service.ChatService;
import com.ctrlaltdefeat.farmtotableconnect.service.UserService;
import com.ctrlaltdefeat.farmtotableconnect.model.Chat;
import com.ctrlaltdefeat.farmtotableconnect.model.Message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.aspectj.apache.bcel.classfile.Module.Open;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.List;




@ClassOrigin(origins="http://localhoost::5176")
@RestController
@RequestMapping("path")
public class ChatController {
    
    @Autowired
    private ChatService chatService;
    
    @GetMapping("/")
    public Chat getChat(@RequestParam Integer customerId, Integer farmerId) {
        Chat chat = chatService.getChat(customerId, farmerId);
        if (chat == null) {
            throw new Exception("No correspdonding messages with farmerId/ccustomerId");
        }
        return chat;
    }

    @PostMapping("/")
    public List<Message> getLatest(@RequestParam Integer chatId, Timestamp latestTimestamp) {
        List<Message> chat = chatService.getLatest(chatId, latestTimestamp);
        if (chat == null) {
            throw new Exception("No messages");
        }
        return chat;
    }
    
    @PostMapping("path")
    public Boolean sendMessage(@RequestBody Message message) {
        Boolean chat = chatService.sendMessage(message);
        if (chat == false) {
            throw new Exception("Cannot send message");
        }
        return chat;
    }

    @PostMapping("path")
    public Boolean finishConveration(@RequestBody Integer chatId) {
        Boolean chat = chatService.finishConversation(chatId);
        if (chat == false) {
            throw new Exception("Cannot finish conversation");
        }
        
        return chat;
    }

    @PostMapping("path")
    public Boolean isFarmerApproved(@RequestBody Integer chatId) {
        Boolean chat = chatService.isFarmerApproved(chatId);
        if (chat == false) {
            throw new Exception("Cannot validate farmer");
        }
        
        return chat;
    }

    @PostMapping("path")
    public Boolean isCustomerApproved(@RequestBody Integer chatId) {
        Boolean chat = chatService.isCustomerApproved(chatId);
        if (chat == false) {
            throw new Exception("Cannot validate farmer");
        }
        
        return chat;
    }
    
    
}
