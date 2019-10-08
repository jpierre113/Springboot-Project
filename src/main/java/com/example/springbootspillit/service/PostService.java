package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Posts;
import org.springframework.http.HttpStatus;

public interface PostService {

    public Posts createPost(Posts posts);

    public Iterable<Posts> listPosts();

    public HttpStatus deleteById(Long userId);
}
