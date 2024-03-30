package com.ctrlaltdefeat.farmtotableconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltdefeat.farmtotableconnect.service.UserService;
import com.ctrlaltdefeat.farmtotableconnect.model.Address;
import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.LoginRequest;
import com.ctrlaltdefeat.farmtotableconnect.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;



@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userSerivce;

    @PostMapping("/login")

    public User getUser(@RequestBody LoginRequest loginRequest) throws Exception {
        try {
            User user = userSerivce.getUserByUsername(loginRequest.getUsername(), loginRequest.getPassword());
            // TODO: Make custom exception
            if (user == null) 
                throw new Exception("Incorrect username or password");
            return user;
        } catch (Exception e) {
            System.out.println("e");
        }
        
        return null;
        
    }

    @PostMapping("/register")
    public User newUser(@RequestBody User user, Farm farm, Address address) {
        return userSerivce.newUser(user, farm, address);
    }
    

    

}
