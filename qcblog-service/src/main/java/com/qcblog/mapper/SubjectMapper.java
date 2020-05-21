package com.qcblog.mapper;

import com.qcblog.pojo.Article;
import com.qcblog.pojo.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SubjectMapper extends Mapper<Subject>{

    @Delete("delete from subject where article_id = #{articleId}")
    public void deleteOne(Integer id);
}
