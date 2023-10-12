package com.twitter.Service;

import com.twitter.Exception.TweetNotFoundException;
import com.twitter.Model.Like;
import com.twitter.Model.Tweet;
import com.twitter.Model.User;
import com.twitter.Repo.LikeRepo;
import com.twitter.Repo.TweetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {

    @Autowired
    private LikeRepo likeRepo;

    @Autowired
    private TweetService tweetService;

    @Autowired
    private TweetRepo tweetRepo;
    public Like likeTweet(String tweetId, User user)throws UsernameNotFoundException, TweetNotFoundException{
        Like isLikeExist=likeRepo.isLikeExist(user.getUserId(),tweetId);

        if(isLikeExist!=null){
            likeRepo.deleteById(isLikeExist.getLikeId());
            return  isLikeExist;
        }
        Tweet tweet = tweetService.findById(tweetId);
        Like like = new Like();
        like.setTweet(tweet);
        like.setUser(user);

        Like savedLike=likeRepo.save(like);
        tweet.getLikes().add(savedLike);
        tweetRepo.save(tweet);
        return savedLike;
    }
    public List<Like> getAllLikes(String tweetId) throws TweetNotFoundException{
        Tweet tweet= tweetService.findById(tweetId);
        List<Like>likes = likeRepo.findByTweetTweetId(tweetId); // TODO check
        return likes;
    }

}
