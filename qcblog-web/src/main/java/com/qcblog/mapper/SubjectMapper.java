package com.qcblog.mapper;

import com.qcblog.pojo.Article;
import com.qcblog.pojo.Subject;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SubjectMapper extends Mapper<Subject>{
    @Select("SELECT a.id,a.atimg,a.atname,a.atpre,a.atpos,a.atcontent,a.atnumber,a.ctime \n" +
            "FROM article a,subject s \n" +
            "WHERE\n" +
            "\ta.id = s.article_id \n" +
            "\tAND s.STATUS = 1 \n" +
            "\tAND s.subname = #{subname}")
    public List<Article> findArticleBySubType(String subname);
}
