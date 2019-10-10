package com.example.springbootspillit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    String body;

    @Column
    private Long user_id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "users_post",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;


    public Posts() { }

    public List<User> getUsers(){ return (List<User>) user; }
    public void setUsers(List<User> users) { this.user = user; }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public  Long getUser_id() {return user_id;}
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}
