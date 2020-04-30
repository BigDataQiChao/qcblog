package com.qcblog.service;

import com.qcblog.mapper.UserMapper;
import com.qcblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        userMapper.updatePersonal(user);
    }
    public void updateImage(User user){
        userMapper.updateImageByUser(user);
    }
    public void updateCarticnum(Integer countUserId,String name){
        userMapper.updateCarticnum(countUserId,name);
    }
    public void addViewCount(User user){
        userMapper.addViewCount(user);
    }

    public User selectUserById(Integer id){
         return userMapper.selectUserById(id);
    }

    public void updatePwd(User user){
        userMapper.updateUserPwd(user);
    }

    public int countByArticleUserId(String name){
        return userMapper.countByArticleUserId(name);
    }

    public User findArticleOneOuthor(Integer id){
        return userMapper.findArticleOneOuthor(id);
    }
}
