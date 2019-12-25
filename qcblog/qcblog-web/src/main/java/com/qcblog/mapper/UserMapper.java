package com.qcblog.mapper;

import com.qcblog.pojo.User;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User> {
    @Update("update user set limit_count = #{limitCount} where id = #{id}")
    public void updateUser(User user);
}
