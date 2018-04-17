package com.chandan.easynotes123.Service;
import com.chandan.easynotes123.Model.UserProfile;

import com.chandan.easynotes123.Repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserProfileServiceImpl implements UserProfielService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public List <UserProfile> getAllProfile() {

        return UserProfile.findAll();
    }

    /*@Override
    public UserProfile addNewProfile(UserProfileDto userProfileDto) {
        UserProfile userProfile= new UserProfile();
        userProfile.setFirstName();
        return null;
    }*/
}
