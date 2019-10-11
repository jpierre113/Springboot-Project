package com.example.springbootspillit.service;
import com.example.springbootspillit.model.Comments;
public interface CommentService {

    //create comment on post using postId
    public Comments createComment(Comments newComment, int postId);

    //list all comments
    public Iterable<Comments> listAllComments();

    //delete comment by commentId
    public void deleteComment(int commentId);
}
