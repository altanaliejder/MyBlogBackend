package com.example.myblog.business.abstracts;

import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.entities.concretes.Role;
import com.example.myblog.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    Result add(User user);
    Result update(User user);
    Result delete(User user);
    DataResult<List<User>> getAll();
    DataResult<User> getUserById(Long id);
    DataResult<User> getUserByEmail(String email);
    DataResult<User> getUserByUsername(String username);
    DataResult<Role> saveRole(Role role);
    Result addStoryToUser(Long userId,Long storyId);
    Result addRoleToUser(String username,String roleName);
    Result deleteAllUser();
}
