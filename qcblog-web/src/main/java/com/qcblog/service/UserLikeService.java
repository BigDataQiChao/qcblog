package com.qcblog.service;

import com.qcblog.mapper.UserLikeMapper;
import com.qcblog.pojo.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserLikeService {
    @Autowired
    private UserLikeMapper userLikeMapper;

    public UserLike findById(Integer entityId,Integer userId){
       return userLikeMapper.findById(entityId,userId);
    }

    public void update(UserLike userLike){
        userLikeMapper.updateByPrimaryKey(userLike);
    }
    public void insert(UserLike userLike){
        userLikeMapper.insert(userLike);
    }
    public List<Map<String,String>> findStatus(Integer userId){
        return userLikeMapper.findStatus(userId);
    }
}
