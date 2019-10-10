package com.example.springbootspillit.controller;



import com.example.springbootspillit.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private com.example.springbootspillit.service.CommentService commentService;

    @GetMapping("/list")
    public Iterable<Comments> listComments(){
        return commentService.listComments();
    }

    @PostMapping("/addComment")
    public Comments createComment(@RequestBody Comments newComments){
        return commentService.createComments(newComments);
    }


    @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable int commentId){
        commentService.deleteById(commentId);
    }

}