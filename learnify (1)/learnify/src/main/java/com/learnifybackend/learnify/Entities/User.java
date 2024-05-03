package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }


}