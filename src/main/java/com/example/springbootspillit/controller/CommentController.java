package com.example.springbootspillit.controller;
import com.example.springbootspillit.model.Comments;
import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.service.CommentService;
import com.example.springbootspillit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    //create comments with post id
    @PostMapping("/create/{postId}")
    public Comments createComment(@PathVariable Long postId, @RequestBody Comments newComment) {
        return commentService.createComment(newComment, postId);
    }
    @GetMapping("/list")
    public Iterable<Comments> listAllComments() {
        return commentService.listAllComments();
    }
    //delete comment by comment id
    @DeleteMapping("/{commentId}")
    public HttpStatus deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return HttpStatus.OK;
    }
}
