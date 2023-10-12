package com.twitter.Dto;

import com.twitter.Model.User;
import lombok.Data;

import java.util.List;

@Data
public class TweetDto {

    private String tweetId;
    private String content;
    private String image;
    private String video;
    private UserDto user;
    private int totalLikes;
    private int totalReplies;
    private int totalReTweet;
    private int isLiked;
    private boolean isReply;
    private boolean isReTweet;
    private List<String> reTweetUserId;
    private List<TweetDto>replyTweets;


}
