package com.example.springbootspillit.repository;

import com.example.springbootspillit.model.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Posts, Integer > {

}
