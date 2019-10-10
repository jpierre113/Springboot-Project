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
    private Comments comments;

    public Comments() { }

    public List<Posts> getPosts(){ return (List<Posts>) comments; }
    public void setPosts(List<Posts> comments) { this.comments = (Comments) comments; }

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

    public  Long getPost_id() {return post_id;}
    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

}
