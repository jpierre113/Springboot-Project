package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Posts createPost(Posts posts) {
        return postRepository.save(posts);
    }

    @Override
    public Iterable<Posts> listPosts() {
        return postRepository.findAll();
    }

    @Override
    public HttpStatus deleteById(Long userId) {
        postRepository.deleteById(userId);
        return HttpStatus.OK;
    }
}
