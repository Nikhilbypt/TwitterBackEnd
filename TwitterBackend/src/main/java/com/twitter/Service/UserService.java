package com.twitter.Service;

import com.twitter.Model.User;
import com.twitter.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private JwtProvider provider  TODO
    public User findUserById(String userId)throws UsernameNotFoundException{
        Optional<User> userOptional =userRepo.findById(userId);
        if(userOptional.isEmpty()){
             throw new UsernameNotFoundException("User Not Present with Id"+userId);
        }
        User user = userOptional.get();
        return user;
    }

    public User findUserProfileByJwt(String jwt)throws UsernameNotFoundException{
        return null; // TODO
    }
    public User updateUser(String userId, User userReq)throws UsernameNotFoundException{
        Optional<User>userOptional=userRepo.findById(userId);
           if(userOptional.isEmpty()){
               throw new UsernameNotFoundException("User Not Found");
           }
           if(!userReq.getFullName().isEmpty()){
               userOptional.get().setFullName(userReq.getFullName());
           }
           if(!userReq.getDp().isEmpty()){
            userOptional.get().setDp(userReq.getDp());
           }
        if(!userReq.getBgImage().isEmpty()){
            userOptional.get().setBgImage(userReq.getBgImage());
        }
        if(!userReq.getBirthDate().isEqual(null)){
            userOptional.get().setBirthDate(userReq.getBirthDate());
        }
        if(!userReq.getLocation().isEmpty()){
            userOptional.get().setLocation(userReq.getLocation());
        }
        if(!userReq.getBio().isEmpty()){
            userOptional.get().setBio(userReq.getBio());
        }
        if(!userReq.getWebsite().isEmpty()){
            userOptional.get().setWebsite(userReq.getWebsite());
        }
        User user= userOptional.get();
        return userRepo.save(user);
    }
    public User followUser(String userId, User user){
        Optional<User> followToUserOp = userRepo.findById(userId);
        User followToUser= followToUserOp.get();

        if(user.getFollowing().contains(followToUser)&& followToUser.getFollowers().contains(user)){
            user.getFollowing().remove(followToUser);
            followToUser.getFollowers().remove(user);
        }
        else{
            user.getFollowing().add(followToUser);
            followToUser.getFollowers().add(user);
        }
    userRepo.save(followToUser);
        userRepo.save(user);
        return followToUser;
    }

    public List<User>searchUser(String query){
//        userRepo.searchUser(query)
return null; // Todo
    }
}
