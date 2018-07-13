package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.UserMapper;
import com.fireengineering.management.po.User;
import com.fireengineering.management.po.UserExample;
import com.fireengineering.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public int getUserCount(){
        UserExample example = new UserExample();
        return userMapper.countByExample(example);
    }

    public List<User> getUserList(Integer offset, Integer limit) {
        return userMapper.selectByLimitAndOffset(offset,limit);
    }

    public int deleteUserById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    public int addUser(User user) {
        return userMapper.insert(user);
    }

    public User getUserByName(String userUsername) {
        return userMapper.selectByName(userUsername);
    }

    public List<User> getAllUserName() {
        return userMapper.getAllName();
    }
}
