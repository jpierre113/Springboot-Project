package com.example.springbootspillit.repository;

import com.example.springbootspillit.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("FROM User u WHERE u.username = ?1 and u.password = ?2")

    public String login(String username, String password);

    public User findByUsername(String username);


}
