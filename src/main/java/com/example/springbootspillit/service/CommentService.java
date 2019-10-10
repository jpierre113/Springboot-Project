package com.example.springbootspillit.service;

import com.example.springbootspillit.model.Comments;
import com.example.springbootspillit.model.Posts;
import org.springframework.http.HttpStatus;

public interface CommentService {

    public Comments createComments(Comments comments);

    public Iterable<Comments> listComments();

    public HttpStatus deleteById(int commentId);
}
