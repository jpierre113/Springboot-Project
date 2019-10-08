package com.example.springbootspillit.model;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    private UserProfile userProfile;

    @Column
    String body;

    @Column
    private Long user_id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "post",
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

    public String getTile() {
        return title;
    }
    public void setTitle(String code) {
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

    public UserProfile getUserProfile() { return userProfile; }
    public void setUserProfile(UserProfile userProfile) {this.userProfile = userProfile; }


}
