package com.chandan.easynotes123.controller;

import com.chandan.easynotes123.Model.User;
import com.chandan.easynotes123.Service.UserService;
import com.chandan.easynotes123.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/addUser")
    public User addNewUser(@RequestBody UserDto userDto){
        return userService.addNewUser(userDto);
    }

    @PutMapping(value = "/edit/{id}")
    public User updateUser(@PathVariable(value = "id")Long userId,
                           @RequestBody UserDto userDto){
        return userService.updateUser(userDto,userId);
    }

    @GetMapping(value = "/edit/{id}")
    public User deleteUser(@PathVariable(value = "id")Long userId){
        return userService.deleteUser(userId);
    }

    @GetMapping(value = "/user/list")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(value = "/user/name")
    public List<User> getByuserName(@RequestParam(value = "username")String userName){
        return userService.getByuserName(userName);
    }
}
