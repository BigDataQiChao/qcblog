package com.qcblog.mapper;

import com.qcblog.pojo.Signinlog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LogMapper extends Mapper<Signinlog> {
    @Select("select count(*) from signinlog where is_delete = 0")
    public String countById();
    @Select("select * from signinlog where id = #{id}")
    public Signinlog selectById(Integer id);
    @Update("update signinlog set logstatus = #{logstatus}, is_delete = #{isDelete} where id = #{id}")
    public void updateStatus(Signinlog signinlog);
    @Delete("delete from signinlog where id = #{id}")
    public void deleteOne(Signinlog signinlog);
    @Select("select * from signinlog where logtime >= (now() - interval 5 minute) and logname = #{logname} and logtype = '管理员'")
    public Signinlog findLimitByName(String logname);
    @Select("select * from ( select * from signinlog order by id desc ) as log where logname = #{logname} and logtype = '管理员' and is_delete = '0' limit 8 ")
    public List<Signinlog> findLogLimitByName(String logname);
    @Update("alter table signinlog DROP id")
    public void dropId();
    @Update("alter table signinlog add id int not null")
    public void createId();
    @Update("alter table signinlog modify column id int not null auto_increment, add primary key(id)")
    public void sortById();
}
