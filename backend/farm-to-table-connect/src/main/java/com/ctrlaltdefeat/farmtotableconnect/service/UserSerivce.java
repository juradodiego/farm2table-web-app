package com.ctrlaltdefeat.farmtotableconnect.service;

import com.ctrlaltdefeat.farmtotableconnect.model.User;

public interface UserSerivce {
    public User getUser(String username, String password);
    public User createUser(User user);
    public User updateUser(User user);
}
