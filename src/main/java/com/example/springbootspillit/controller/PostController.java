package com.example.springbootspillit.controller;



import com.example.springbootspillit.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private com.example.springbootspillit.service.PostService postService;

    @GetMapping("/list")
    public Iterable<Posts> listPosts(){
        return postService.listPosts();
    }

    @PostMapping("/addPost")
    public Posts createPost(@RequestBody Posts newPost){
        return postService.createPost(newPost);
    }


    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){
        postService.deleteById(postId);
    }

}