package com.example.springbootspillit.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(unique = true)
    //private String post;
    //public Posts(){}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
   // public String getPosts(){
    //    return post;
    //}
   // public void setPosts(String post){ this.post = post;
   // }

    @Column
    private String title;

    @Column
    private String body;

   // @Column(unique = true)
    //private String username;

    public String getTitle() {return title;}
    public void setTitle(String title) { this.title = title;}

    public String getBody() {return body;}
    public void setBody(String body) {this.body = body; }

    //connecting to posts to  users
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")

    private User users;
    public User getUser(){
        return users;
    }
    public void setUser(User user){
        this.users = user;
    }
    }
