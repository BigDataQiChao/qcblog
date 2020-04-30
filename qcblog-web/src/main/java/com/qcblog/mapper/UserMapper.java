package com.qcblog.mapper;

import com.qcblog.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User> {
    @Update("update user set limit_count = #{limitCount} where id = #{id}")
    public void updateUser(User user);

    @Update("update user set view_count = #{viewCount}+1 where id = #{id}")
    public void addViewCount(User user);

    @Update("update user set username = #{username},truename = #{truename},industry = #{industry},utime = #{utime},telephone = #{telephone},sex = #{sex}, email = #{email},wk_condition = #{wkCondition},intro = #{intro},sch_name = #{schName},education = #{education}  where id = #{id}")
    public void updatePersonal(User user);

    @Select("select * from user where id = #{id}")
    public User selectUserById(Integer id);

    @Update("update user set password = #{password},repassword = #{password} where id = #{id}")
    public void updateUserPwd(User user);

    @Select("select count(*) from article a,user u where a.user_id = u.id and u.username=#{username};")
    public int countByArticleUserId(String username);

    @Update("update user set image = #{image} where id = #{id}")
    public void updateImageByUser(User user);

    @Update("update user set carticnum = #{carticnum} where username = #{username}")
    public void updateCarticnum(@Param("carticnum") Integer countUserId, @Param("username")String name);

    @Select("select u.* from user u, article a where u.id = a.user_id and a.id = #{id}")
    public User findArticleOneOuthor(Integer id);
}
