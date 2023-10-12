package com.twitter.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data

public class Tweet {
    @Id
    private String tweetId;

    @ManyToOne
    private User user;

    private String content;
    private String image;
    private String video;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Like> likes= new ArrayList<>();

    @OneToMany
    private List<Tweet> replyTweets= new ArrayList<>();

    @ManyToMany
    private List<User>retweetUser= new ArrayList<>();

    @ManyToOne
    private Tweet replyFor;

    private boolean isReply;
    private boolean isTweet;
    private LocalDateTime createdAt;

    public Tweet() {
        this.tweetId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}