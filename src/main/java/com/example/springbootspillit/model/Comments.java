package com.example.springbootspillit.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String body;

    @Column
    private Long post_id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "posts",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Posts posts;

    public Comments() { }

    public List<User> getUsers(){ return (List<User>) posts; }
    public void setUsers(List<User> users) { this.posts = posts; }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public  Long getUser_id() {return post_id;}
    public void setUser_id(Long post_id) {
        this.post_id = post_id;
    }

}
