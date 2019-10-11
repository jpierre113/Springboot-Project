package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.model.User;
import com.example.springbootspillit.repository.PostRepository;
import com.example.springbootspillit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Posts createPost(Posts newPost, Long userId) {
        User user = userRepository.findById(userId).get();
        newPost.setUser(user);
        return postRepository.save(newPost);
    }


    public Iterable<Posts> listPosts() {
        return (Iterable<Posts>) postRepository.findAll();
    }

    @Override
    public void deleteById(int postId) {
        postRepository.deleteById(postId);

    }

}
