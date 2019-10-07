package com.example.springbootspillit.service;

import com.example.springbootspillit.model.User;
import com.example.springbootspillit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> listUsers(){
        return userRepository.findAll();
    }
}
