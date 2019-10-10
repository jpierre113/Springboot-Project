package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Comments;
import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.repository.CommentRepository;
import com.example.springbootspillit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comments createComments(Comments comments) {
        return commentRepository.save(comments);
    }

    @Override
    public Iterable<Comments> listComments() {
        return commentRepository.findAll();
    }

    @Override
    public HttpStatus deleteById(int commentId) {
        commentRepository.deleteById(commentId);
        return HttpStatus.OK;
    }
}
