package com.chandan.easynotes123.Service;



import com.chandan.easynotes123.Model.Status;
import com.chandan.easynotes123.Model.User;
import com.chandan.easynotes123.Repository.UserRepository;
import com.chandan.easynotes123.dto.UserDto;
import com.chandan.easynotes123.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.chandan.easynotes123.Model.Status.ACTIVE;

@Service
public class UserServiceImpl implements UserService{

    /**
     *
     */
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addNewUser(UserDto userDto) {
        User user= new User();
        user.setUsername(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setDisplayName(user.getDisplayName());
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    @Override
     public User updateUser(UserDto userDto, Long userId) {
        User user= userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User", "id", userId));
        user.setUsername(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setDisplayName(userDto.getDisplayName());
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long userId) {
        User user= userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User", "id", userId));
        user.setStatus(Status.INACTIVE);
                return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByuserName(String userName) {
        return userRepository.getByuserName(userName);
    }


}
