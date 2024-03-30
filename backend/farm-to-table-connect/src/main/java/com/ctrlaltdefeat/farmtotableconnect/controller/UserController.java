package com.ctrlaltdefeat.farmtotableconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltdefeat.farmtotableconnect.service.UserService;
import com.ctrlaltdefeat.farmtotableconnect.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@CrossOrigin(origins="http://localhost:5176")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userSerivce;

    @GetMapping("/login")
    public User getUser(@RequestBody String username, String password) throws Exception {
        User user = userSerivce.getUserByUsername(username, password);
        // TODO: Make custom exception
        if (user == null) 
            throw new Exception("Incorrect username or password");
        return user;
    }

    @PostMapping("/register")
    public User postMethodName(@RequestBody User user) {
        return userSerivce.newUser(user);
    }
    

    

}
