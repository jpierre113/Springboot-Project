package com.example.springbootspillit.service;
import com.example.springbootspillit.config.JwtUtil;
import com.example.springbootspillit.model.User;
import com.example.springbootspillit.repository.PostRepository;
import com.example.springbootspillit.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;


    @InjectMocks
    private User user;

    @Before
    public void initializeDummyUser() {
        user.setUsername("red");
        user.setPassword("blue");
    }

    // test is successful even with wrong password
    @Test
    public void getUser_ReturnsUser_Success() {

        when(userRepository.findByUsername(anyString())).thenReturn(user);

        User tempUser = userService.getUser(user.getUsername());

        assertEquals(tempUser.getUsername(), user.getUsername());
    }

    @Test
    public void login_UserNotFound_Error() {

        when(userRepository.findByUsername(anyString())).thenReturn(null);

        String token = userService.login(user);

        assertEquals(token, null);
    }
}
