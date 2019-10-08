package com.example.springbootspillit.service;

import com.example.springbootspillit.config.JwtUtil;
import com.example.springbootspillit.model.Posts;
import com.example.springbootspillit.model.User;
import com.example.springbootspillit.model.UserRole;
import com.example.springbootspillit.repository.PostRepository;
import com.example.springbootspillit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


    @Autowired
    com.example.springbootspillit.service.UserRoleService userRoleService;

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));

        return authorities;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);
        return null;

    }
}
