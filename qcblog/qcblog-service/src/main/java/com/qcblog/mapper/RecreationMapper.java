package com.qcblog.mapper;

import com.qcblog.pojo.Recreation;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface RecreationMapper extends Mapper<Recreation> {
    @Select("select count(*) from recreation where is_delete = 0")
    public String countById();
}
