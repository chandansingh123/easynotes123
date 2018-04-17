package com.chandan.easynotes123.Repository;

import com.chandan.easynotes123.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> getByuserName(String userName);
    /*List<User> getByuserName(String userName);
    @Query("select u from User u where u.username =:username")
    List<User> getByuserName(@Param(value = "username") String userName);*/
}
