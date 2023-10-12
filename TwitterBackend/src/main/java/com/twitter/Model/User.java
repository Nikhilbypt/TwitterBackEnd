package com.twitter.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data

public class User {
    @Id
    private String userId;

    private String fullName;
    private String dp;
    private String bgImage;
    private String email;//
    private int emailOtp; //no
    private String password;  //no
    private Long phoneNo; //
    private String userName;//
    private String bio;
    private LocalDate birthDate;
    private String website;
    private String location;
    private String work;
    private String reqUser;//
    private boolean isLoginWithGoogle;//

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tweet> tweetList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @Embedded
    private Verification verification;

    @ManyToMany
    private List<User>followers=new ArrayList<>();

    @ManyToMany
    private List<User>following=new ArrayList<>();



    private LocalDateTime createdAt;

    public User() {
        this.userId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}
