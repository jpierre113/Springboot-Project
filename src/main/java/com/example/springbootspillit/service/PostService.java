package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Posts;

public interface PostService {

    public Posts createPost(Posts posts);

    public Iterable<Posts> listCourses();
}
