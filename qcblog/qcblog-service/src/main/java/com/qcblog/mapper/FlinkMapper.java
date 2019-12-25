package com.qcblog.mapper;

import com.qcblog.pojo.Flink;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface FlinkMapper extends Mapper<Flink> {
    @Select("select count(*) from flink where is_delete = 0")
    public String countById();
    @Select("select * from flink where flname = #{flname}")
    public Flink findByName(String flname);
    @Update("update flink set is_delete = #{isDelete} where id = #{id}")
    public void deleteOne(Flink flink);
}
