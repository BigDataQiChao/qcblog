package com.qcblog.mapper;


import java.util.List;

import com.qcblog.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{
    @Select("select count(*) from user where is_delete = 0")
    public String countById();
    @Select("select * from user where username = #{username}")
    public User findByName(String username);
    @Update("update user set username = #{username},update_time = #{updateTime}, password = #{password},telephone = #{telephone},role = #{role}, repassword = #{repassword}, email = #{email} where id = #{id}")
    public void update(User user);
    @Update("update user set status = #{status} where id = #{id}")
    public void updateForbidden(User user);
    @Update("update user set is_delete = #{isDelete} where id = #{id}")
    public void deleteOne(User user);
}