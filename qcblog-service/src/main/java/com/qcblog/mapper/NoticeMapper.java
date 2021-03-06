package com.qcblog.mapper;

import com.qcblog.pojo.Notice;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface NoticeMapper extends Mapper<Notice> {
    @Select("select count(*) from notice where is_delete = 0")
    public String countById();
    @Select("select count(*) from notice where ntstatus = 1")
    public String countByStatus();
    @Select("select * from notice where id = #{id}")
    public Notice findById(Integer id);
    @Select("select * from notice where ntname = #{ntname}")
    public Notice findByName(String ntname);
    @Update("update notice set ntstatus = #{ntstatus} where id = #{id}")
    public void updateNoticeStatus(Notice notice);
}
