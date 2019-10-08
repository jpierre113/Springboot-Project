package com.example.springbootspillit.service;

import com.example.springbootspillit.model.User;
import com.example.springbootspillit.model.UserProfile;

public interface UserProfileService {

    public UserProfile createUserProfile(String username, UserProfile newProfile);

    public UserProfile getUserProfile(String username);

    User getUser(String username);

    User createUser(User user);
}