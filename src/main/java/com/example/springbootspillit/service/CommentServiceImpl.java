package com.example.springbootspillit.service;
import com.example.springbootspillit.model.Comments;
import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.repository.CommentRepository;
import com.example.springbootspillit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    @Autowired
    PostRepository postRepository;
    //create comment with post id
    @Override
    public Comments createComment(Comments newComment, Long postId) {
        Posts posts = postRepository.findById(Math.toIntExact(postId)).get();
        newComment.setPost(posts);
        return commentRepository.save(newComment);
    }
    public Iterable<Comments> listAllComments() {
        return commentRepository.findAll();
    }
    //delete comment by comment id
    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
