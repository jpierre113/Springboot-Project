package com.example.springbootspillit.controller;



import com.example.springbootspillit.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private com.example.springbootspillit.service.PostService postService;

    @PostMapping("/addPost/{userId}")
    public Posts createPost(@PathVariable Long userId, @RequestBody Posts newPost) {
        return postService.createPost(newPost, userId);
    }
        @GetMapping("/list")
        public Iterable<Posts> listPosts(){ return postService.listPosts();}

        @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable int postId){
        postService.deleteById(postId);

    }
}