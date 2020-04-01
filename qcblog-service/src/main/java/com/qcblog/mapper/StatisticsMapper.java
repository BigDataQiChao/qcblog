package com.qcblog.mapper;

import com.qcblog.pojo.Statistics;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface StatisticsMapper extends Mapper<Statistics> {
    @Select("select * from statistics where id = #{id}")
    public Statistics selectById(Integer id);
}
