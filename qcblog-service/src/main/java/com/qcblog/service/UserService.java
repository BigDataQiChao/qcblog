package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.UserMapper;
import com.qcblog.pojo.User;
import com.qcblog.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    public void add(User user) {
        userMapper.insert(user);
    }


    public User findOne(String name) {
        return userMapper.findByName(name);
    }
    /**
     * 修改
     */
    public void update(User user){
        userMapper.update(user);
    }

    /**
     * 禁用启用
     */
    public void updateForbidden(User user){
        userMapper.updateForbidden(user);
    }
    /**
     * 批量删除
     * @param ids
     */
    public void delete(Integer[] ids) {
        for(Integer id:ids){
            userMapper.deleteByPrimaryKey(id);
        }
    }
    /**
     * 单体删除
     * @param user
     */
    public void deleteOne(User user) {
        userMapper.deleteOne(user);
    }

    /**
     * 通过ID 查询
     * @return
     */
    public User selectById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public String countById(){
        return userMapper.countById();
    }
    public PageResult findPage(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user!=null){
            if(user.getUsername()!=null && user.getUsername().length()>0){
                criteria.andUsernameLike("%"+user.getUsername()+"%");
            }
            if(user.getPassword()!=null && user.getPassword().length()>0){
                criteria.andPasswordLike("%"+user.getPassword()+"%");
            }

            if(user.getStatus()!=null && user.getStatus().length()>0){
                criteria.andStatusEqualTo(user.getStatus());
            }
        }
        Page<User> page= (Page<User>)userMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 按分页查询
     */

    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page=   (Page<User>) userMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
    public int countByArticleUserId(){
        return userMapper.countByArticleUserId();
    }
    public void updateCarticnum(Integer carticnum){
        userMapper.updateCarticnum(carticnum);
    }
}
