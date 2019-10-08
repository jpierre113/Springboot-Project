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
    @JoinColumn(name="users_id")
    private UserProfile userProfile;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole userRole;
    @JoinColumn(name="user_post_id")
    private Post userPost;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
  
    @JoinTable(name = "users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "post_id"))
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

    public UserRole getUserRole() { return userRole; }


    public UserProfile getUserProfile() { return userProfile; }

    public void setUserProfile(UserProfile userProfile) {this.userProfile = userProfile; }

    public Long getId() {

    @JoinTable(name = "user_post",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> posts;

    public User(){}

    public List<Post> addPost(Post post){
        if(posts == null)
            posts = new ArrayList<>();

        posts.add(post);

        return posts;
    }

    //getters and setters
    public Integer getId(){
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

    public void setUserRole(UserRole userRole) {
    }
        this.userRole = userRole;

    }


    //getters & setters for post
    public List<Post> getPosts(){ return posts; }

    public void setPosts(List<Post> posts) { this.posts = posts; }
}
