package com.qcblog.mapper;

import com.qcblog.pojo.Signinlog;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface LogMapper extends Mapper<Signinlog> {
    @Select("select * from signinlog where logtime >= (now() - interval 10 minute) and logname = #{logname} and logtype = '平台用户'")
    public Signinlog findLimitByName(String logname);
}
