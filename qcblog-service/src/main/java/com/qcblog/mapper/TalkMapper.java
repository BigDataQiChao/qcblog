package com.qcblog.mapper;

import com.qcblog.pojo.Slideshow;
import com.qcblog.pojo.Talk;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface TalkMapper extends Mapper<Talk> {
    @Select("select count(*) from talk where is_delete = 0")
    public String countById();
    @Select("select * from talk where tktitle = #{tktitle}")
    public Talk findByName(String tktitle);
    @Update("update talk set is_delete = #{isDelete} where id = #{id}")
    public void deleteOne(Talk talk);
}
