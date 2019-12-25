package com.qcblog.service;

import com.qcblog.common.Result;
import com.qcblog.mapper.UserMapper;
import com.qcblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public User findUserByName(String name) {
        User user = new User();
        user.setUsername(name);
        return userMapper.selectOne(user);
    }
    public void insert(User user){
        userMapper.insert(user);
    }

    public void subtractUser(User user){
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        user.setLimitCount(user1.getLimitCount()-1);
        userMapper.updateUser(user);
    }
    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }
}
