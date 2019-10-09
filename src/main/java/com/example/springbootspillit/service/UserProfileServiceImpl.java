package com.example.springbootspillit.service;


import com.example.springbootspillit.model.User;
import com.example.springbootspillit.model.UserProfile;
import com.example.springbootspillit.repository.UserProfileRepository;
import com.example.springbootspillit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserRepository userRepository;


    User user;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        User user = userRepository.findByUsername(username);
        //Null pointer problem
        user.setUserProfile(newProfile);
        return userProfileRepository.save(newProfile);
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return userProfileRepository.findProfileByUsername(username);
    }


}