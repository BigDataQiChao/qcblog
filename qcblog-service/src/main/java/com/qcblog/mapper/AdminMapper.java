package com.qcblog.mapper;

import com.qcblog.pojo.Admin;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 管理员sql映射类
 */
public interface AdminMapper extends Mapper<Admin> {
    @Select("select count(*) from admin where is_delete = 0")
    public String countById();
    @Select("select * from article where admin_name = #{adminName}")
    public Admin findByName(String adminName);
}
