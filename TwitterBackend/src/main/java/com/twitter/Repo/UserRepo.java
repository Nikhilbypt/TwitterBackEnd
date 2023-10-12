package com.twitter.Repo;

import com.twitter.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,String> {
    public User findByEmail(String email);
    public User findByFullName(String fullname);

}
