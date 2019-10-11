package com.example.springbootspillit.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String comment;
    public Comments(){}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getComments(){
        return comment;
    }
    public void setComments(String comment){ this.comment = comment;
    }
    //connecting to comments to  posts
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "post_id")

    private Posts posts;
    public Posts getPost(){
        return posts;
    }
    public void setPost(Posts posts){
        this.posts = posts;
    }
}
