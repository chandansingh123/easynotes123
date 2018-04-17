package com.chandan.easynotes123.controller;


import com.chandan.easynotes123.Model.UserProfile;
import com.chandan.easynotes123.Service.UserProfielService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    private final UserProfielService userProfielService;

    public UserProfileController(UserProfielService userProfielService) {
        this.userProfielService = userProfielService;
    }


    @GetMapping(value = "/userProfile")
    public List<UserProfile> getAllProfile(){
        return userProfielService.getAllProfile();
    }

    /*@PostMapping(value = "/addProfile")
    public UserProfile addNewProfile(@RequestBody UserProfileDto userProfileDto){
        return userProfielService.addNewProfile(userProfileDto);
    }*/


}
