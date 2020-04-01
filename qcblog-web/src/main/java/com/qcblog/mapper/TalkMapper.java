package com.qcblog.mapper;

import com.qcblog.pojo.Talk;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TalkMapper extends Mapper<Talk>{

    @Select("select * from talk where tktitle = #{tktitle}")
    public String findOne(String tktitle);
}
