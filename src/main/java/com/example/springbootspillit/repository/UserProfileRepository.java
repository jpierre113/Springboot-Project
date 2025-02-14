package com.example.springbootspillit.repository;

import com.example.springbootspillit.model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long>{

    @Query("from UserProfile up left join User u on u.username = ?1 and up.id = u.userProfile.id")
    public UserProfile findProfileByUsername(String username);
}