package com.qcblog.mapper;

import com.qcblog.pojo.Article;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
public interface ArticleMapper extends Mapper<Article>{

    @Select("select * from article where atname = #{atname}")
    public Article findByName(String atname);

    @Update("update article set atnumber = #{atnumber}+1 where id = #{id}")
    public void updateArticle(Article article);

    @Select("select * from article where status = 1 and id < #{id} order by id desc limit 1")
    public Article preArticle(Integer id);

    @Select("select * from article where status = 1 and id > #{id} order by id asc limit 1")
    public Article nextArticle(Integer id);
}
