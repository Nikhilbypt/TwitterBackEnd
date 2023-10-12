package com.twitter.Dto;

import lombok.Data;

@Data
public class LikeDto {

    private String likeId;
    private UserDto user;
    private TweetDto tweet;
}
