package com.example.springbootspillit.service;


import com.example.springbootspillit.model.User;
import com.example.springbootspillit.model.UserProfile;
import com.example.springbootspillit.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserProfileService userProfileService;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        User user = userProfileService.getUser(username);
        user.setUserProfile(newProfile);
        return userProfileRepository.save(newProfile);
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return userProfileRepository.findProfileByUsername(username);
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }
}