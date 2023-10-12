package com.twitter.Dto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TweetReplyReq {

    private String content;
    private String tweetId;
    private String image;
    private LocalDateTime createdAt;
}
