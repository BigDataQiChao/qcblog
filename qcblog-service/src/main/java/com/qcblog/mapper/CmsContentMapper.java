package com.qcblog.mapper;

import com.qcblog.pojo.CmsContent;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CmsContentMapper extends Mapper<CmsContent> {

    @Select("select * from cms_content order by title")
    public List<CmsContent> findCmsAll();

    @Select("select * from cms_content where id =#{id}")
    public CmsContent findCmsOne(String id);
}
