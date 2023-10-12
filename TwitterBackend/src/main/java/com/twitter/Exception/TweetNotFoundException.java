package com.twitter.Exception;

public class TweetNotFoundException extends Exception {
    public TweetNotFoundException(String message){
        super(message);
    }
}
