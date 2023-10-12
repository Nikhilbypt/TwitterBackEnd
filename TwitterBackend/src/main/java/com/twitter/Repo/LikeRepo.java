package com.twitter.Repo;

import com.twitter.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepo extends JpaRepository<Like, String> {

    @Query("Select l from Like l where l.user.userId= :userId AND l.tweet.tweetId=:tweetId")
    public Like isLikeExist(@Param("userId") String userId, @Param("tweetId") String tweetId);

    List<Like>findByTweetTweetId(String tweetId);

}
