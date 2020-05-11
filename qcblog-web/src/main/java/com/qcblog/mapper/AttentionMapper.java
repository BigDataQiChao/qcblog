package com.qcblog.mapper;

import com.qcblog.pojo.Attention;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttentionMapper extends Mapper<Attention> {
    @Select("select * from attention where focus_id = #{focusId} and focused_id = #{focusedId} and status = 1")
    public List<Attention> checkIsAttention(@Param("focusId") Integer focusId,@Param("focusedId") Integer focusedId);

    @Delete("delete from attention where focus_id = #{focusId} and focused_id = #{focusedId} and status = 1")
    public void deleAttention(@Param("focusId") Integer focusId, @Param("focusedId") Integer focusedId);
}
