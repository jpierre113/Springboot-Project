package com.example.springbootspillit.controller;

import com.example.springbootspillit.model.JwtResponse;
import com.example.springbootspillit.model.User;
import com.example.springbootspillit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user/list")
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PutMapping("/users/{username}/{post_id}")
    public User addPost(@PathVariable String username, @PathVariable Long post_id){
        return userService.addPost(username, post_id);
    }

    @DeleteMapping("/user/{user_id}")
    public HttpStatus deleteUserById(@PathVariable Long user_id) {
        return userService.deleteById(user_id);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }

}