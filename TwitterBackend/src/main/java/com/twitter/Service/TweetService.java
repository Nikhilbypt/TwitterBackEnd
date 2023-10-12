package com.twitter.Service;

import com.twitter.Dto.TweetReplyReq;
import com.twitter.Dto.UserDto;
import com.twitter.Exception.TweetNotFoundException;
import com.twitter.Model.Tweet;
import com.twitter.Model.User;
import com.twitter.Repo.TweetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {

    @Autowired
    private TweetRepo tweetRepo;

    public Tweet createTweet(Tweet req, User user)throws UsernameNotFoundException{
       Tweet tweet= new Tweet();
        tweet.setContent(req.getContent());
        tweet.setImage(req.getImage());
//        tweet.setUser(req.getUser());
        tweet.setUser(user);
        tweet.setReply(false);
        tweet.setTweet(true);
        tweet.setVideo(req.getVideo());

        tweetRepo.save(tweet);
        return tweet;
    }

    public List<Tweet> findAll(){
        return tweetRepo.findAllByIsTweetTrueOrderByCreatedAtDesc() ;
    }

    public Tweet reTweet(String tweetId, User user)throws UsernameNotFoundException{
        Optional<Tweet> tweetOptional = tweetRepo.findById(tweetId);
        Tweet tweet  = tweetOptional.get();
        if(tweet.getRetweetUser().contains(user)){
            tweet.getRetweetUser().remove(user);
        }else {
            tweet.getRetweetUser().add(user);
        }
        return tweetRepo.save(tweet);
    }
    public Tweet findById(String tweetId) throws TweetNotFoundException {
        Optional<Tweet> tweetOptional = tweetRepo.findById(tweetId);
        if(tweetOptional.isEmpty()){
           throw new TweetNotFoundException("Tweet not found"+ tweetId);
        }
        Tweet tweet = tweetOptional.get();
        return tweet;
    }
    public  void deleteTweetById(String tweetId, String userId){
        Optional<Tweet> tweetOptional= tweetRepo.findById(tweetId);

        if(! userId.equals(tweetOptional.get().getUser().getUserId())){
            throw new UsernameNotFoundException( "You can't delete another users tweet");
        }
        tweetRepo.deleteById(tweetOptional.get().getTweetId());
    }
     public Tweet createReply(TweetReplyReq req, User user ) throws TweetNotFoundException {
        Tweet replyFor= findById(req.getTweetId());

         Tweet tweet= new Tweet();
         tweet.setContent(req.getContent());
         tweet.setImage(req.getImage());
         tweet.setUser(user);
         tweet.setReply(true);
         tweet.setTweet(false);
         tweet.setReplyFor(replyFor);

         Tweet savedReply = tweetRepo.save(tweet);
         tweet.getReplyTweets().add(savedReply);

         return replyFor;

     }

     public List<Tweet>getByUser(User user){   //== getUserTweet
        return tweetRepo.findByRetweetUserContainsOrUser_UserIdAndIsTweetTrue(user, user.getUserId());
     }
     public List<Tweet>findByLikesContainsUser(User user){

        return tweetRepo.findByLikesUser_id(user.getUserId());
     }


}
