package com.example.springbootspillit.service;


import com.example.springbootspillit.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceStub implements UserService {

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    @Override
    public Iterable<User> listUsers() {
        return null;
    }

    @Override
    public String createUser(User newUser) {
        return null;
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public HttpStatus deleteById(Long userId) {
        return null;
    }

    @Override
    public User addPost(String username, int postId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
