package com.example.springbootspillit.service;

import com.example.springbootspillit.model.User;

public interface UserService {
    //calling getter from User model
    public User getUser(String username);

    public Iterable<User> listUsers();

    public String createUser(User newUser);

    public String login(User user);
}
