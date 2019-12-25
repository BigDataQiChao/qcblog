package com.qcblog.mapper;

import com.qcblog.pojo.Numbers;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface NumbersMapper extends Mapper<Numbers> {
    @Update("update numbers set tnumber = #{tnumber}+1,wnumber = #{wnumber}+1 where id = #{id}")
    public void updateNumber(Numbers numbers);
}
