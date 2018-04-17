package com.chandan.easynotes123.Service;

import com.chandan.easynotes123.Model.User;
import com.chandan.easynotes123.dto.UserDto;

import java.util.List;

public interface UserService {
    User addNewUser(UserDto userDto);

    User updateUser(UserDto userDto, Long userId);

    User deleteUser(Long userId);


    List<User> getAllUser();

    List<User> getByuserName(String userName);
}
