package com.fireengineering.management.service;

import com.fireengineering.management.po.User;

import java.util.List;

public interface UserService {
    public int getUserCount();

    public List<User> getUserList(Integer offset, Integer limit);

    public int deleteUserById(Integer userId);

    public int addUser(User user);

    public User getUserByUsername(String userUsername);

    public List<User> getAllUserName();
}
