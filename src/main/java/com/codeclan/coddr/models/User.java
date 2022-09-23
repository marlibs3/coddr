package com.codeclan.coddr.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Post> posts;

    public User(){
    }

    public User(String username, String bio){
        this.username = username;
        this.bio = bio;
        this.posts = new ArrayList<>();
    }

}
