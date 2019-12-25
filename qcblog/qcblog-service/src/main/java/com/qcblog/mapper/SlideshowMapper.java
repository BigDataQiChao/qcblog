package com.qcblog.mapper;

import com.qcblog.pojo.Slideshow;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface SlideshowMapper extends Mapper<Slideshow> {
    @Select("select count(*) from slideshow where is_delete = 0")
    public String countById();
}
