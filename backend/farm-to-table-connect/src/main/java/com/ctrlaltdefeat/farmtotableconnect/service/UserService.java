package com.ctrlaltdefeat.farmtotableconnect.service;

import com.ctrlaltdefeat.farmtotableconnect.model.Address;
import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.User;

public interface UserService {
    
    public User getUserByUsername(String username, String password);
    public User getUserByUserId(Integer userId);
    public User newUser(User user, Farm farm, Address address);
}
