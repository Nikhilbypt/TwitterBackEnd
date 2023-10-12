package com.twitter.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private String userId;

    private String fullName;
    private String dp;
    private String bgImage;
    private String email;
    private String bio;
    private Long phoneNo;
    private LocalDate birthDate;
    private String website;
    private String location;
    private boolean reqUser;
    private boolean login_with_google ;
    private boolean followed;
    private List<UserDto> followers=new ArrayList<>();
    private List<UserDto> following=new ArrayList<>();
    private boolean isVerified;
}
