package com.example.springbootspillit.service;

import com.example.springbootspillit.model.User;
import com.example.springbootspillit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> listUsers(){
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);
        return null;
    }
}
