package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Posts createPost(Posts Posts) {
        return postRepository.save(Posts);
    }

    @Override
    public Iterable<Posts> listCourses(){
        return postRepository.findAll();
    }
}
