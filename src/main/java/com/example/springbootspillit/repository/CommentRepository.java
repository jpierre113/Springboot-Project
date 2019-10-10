package com.example.springbootspillit.repository;
import com.example.springbootspillit.model.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface CommentRepository extends CrudRepository<Comments, Long> {
}
