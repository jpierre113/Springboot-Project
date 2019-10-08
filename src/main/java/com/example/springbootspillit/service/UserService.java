package com.example.springbootspillit.service;

import com.example.springbootspillit.model.User;
import com.example.springbootspillit.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    public User getUser(String username);

    public Iterable<User> listUsers();

    public String createUser(User newUser);

    public String login(User user);

    //public HttpStatus findById(Long userId);

    public HttpStatus deleteById(Long userId);

    public User addPost(String username, Long postId);
}