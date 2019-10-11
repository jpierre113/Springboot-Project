package com.example.springbootspillit.controller;


import com.example.springbootspillit.model.UserProfile;
import com.example.springbootspillit.service.UserProfileServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {

    private UserProfileController userProfileController;

    @Before
    public void initializeUserProfileController(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());
    }

    @Test
    public void createUserProfile_SavesUserProfile_Success() throws Exception{
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("green@aol.com");

        UserProfile newProfile = userProfileController.createUserProfile("green", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }
}
