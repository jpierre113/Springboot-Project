package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Posts;

public interface PostService {

    public Posts createPost(Posts newPost, Long userId);

    public Iterable<Posts> listPosts();

    public void deleteById(int userId);
}
