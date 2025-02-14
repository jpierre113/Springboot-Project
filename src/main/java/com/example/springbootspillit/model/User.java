package com.example.springbootspillit.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_profile_id")
    private UserProfile userProfile;



    @OneToMany( mappedBy = "users",
            cascade = CascadeType.ALL)
                    //CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "users_id",
            //joinColumns = {@JoinColumn(name = "user_id")},
            //inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Posts> posts;

    public User() {}

    public List<Posts> addPost(Posts post){
        if(posts == null)
            posts = new ArrayList<>();
        posts.add(post);
        return posts;
    }

    public List<Posts> getPosts(){ return posts; }
    public void setPosts(List<Posts> posts) { this.posts = posts; }

    public UserProfile getUserProfile() { return userProfile; }
    public void setUserProfile(UserProfile userProfile) {this.userProfile = userProfile; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    }

