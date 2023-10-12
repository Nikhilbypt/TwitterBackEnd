package com.twitter.Repo;

import com.twitter.Model.Tweet;
import com.twitter.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TweetRepo extends JpaRepository<Tweet,String> {

//    List<Tweet> findTweetByIsTweetTrue
    List<Tweet> findAllByIsTweetTrueOrderByCreatedAtDesc();
    List<Tweet>findByRetweetUserContainsOrUser_UserIdAndIsTweetTrue(User user, String userId);
    List<Tweet>findByLikesContaining(User user);
    List<Tweet>findByUser_UserId(String userId);

    @Query("select t from Tweet t join t.likes l where l.user.userId=: userId")
    List<Tweet>findByLikesUser_id(String userId);
}
