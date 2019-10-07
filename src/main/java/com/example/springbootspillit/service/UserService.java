package com.example.springbootspillit.service;

import com.example.springbootspillit.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    //calling getter from User model
    public User getUser(String username);

    public Iterable<User> listUsers();

    public User createUser(User newUser);

    public String login(User user);
}
