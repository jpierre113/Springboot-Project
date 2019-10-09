package com.example.springbootspillit.controller;



import com.example.springbootspillit.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private com.example.springbootspillit.service.PostService postService;

    @GetMapping("/post/list")
    public Iterable<Posts> listPosts(){
        return postService.listPosts();
    }

    @PostMapping("/addPost")
    public Posts createPost(@RequestBody Posts newPost){
        return postService.createPost(newPost);
    }


    @DeleteMapping("/post/{postId}")
    public void deletePostById(@PathVariable long postId){
        postService.deleteById(postId);
    }

}