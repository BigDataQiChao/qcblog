package com.qcblog.service;

import com.qcblog.mapper.NumbersMapper;
import com.qcblog.mapper.UserMapper;
import com.qcblog.pojo.Numbers;
import com.qcblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {

    @Autowired
    private NumbersMapper numbersMapper;
    @Autowired
    private UserMapper userMapper;


 /*   public void findById(Integer id){
        Numbers numbers = new Numbers();
        numbers.setId(id);
        numbersMapper.selectByPrimaryKey(numbers);
    }*/

    public void updateNumber(Numbers numbers,User user){
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        user.setLimitCount(user1.getLimitCount()+1);
        userMapper.updateUser(user);
        Numbers no = numbersMapper.selectByPrimaryKey(1);
        numbers.setId(no.getId());
        numbers.setTnumber(no.getTnumber());
        numbers.setWnumber(no.getWnumber());
        numbersMapper.updateNumber(numbers);
    }
    public void updateNumber(Numbers numbers){
        Numbers no = numbersMapper.selectByPrimaryKey(1);
        numbers.setId(no.getId());
        numbers.setTnumber(no.getTnumber());
        numbers.setWnumber(no.getWnumber());
        numbersMapper.updateNumber(numbers);
    }
    public Numbers queryNumber(Integer id){
        return numbersMapper.selectByPrimaryKey(id);
    }
}
