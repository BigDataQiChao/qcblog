package com.qcblog.mapper;

import com.qcblog.pojo.Article;
import com.qcblog.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends Mapper<Article>{

    @Select("select * from article where atname = #{atname}")
    public Article findByName(String atname);

    @Update("update article set atnumber = #{atnumber}+1 where id = #{id}")
    public void updateArticle(Article article);

    @Select("select * from article where status = 1 and id < #{id} order by id desc limit 1")
    public Article preArticle(Integer id);

    @Select("select * from article where status = 1 and id > #{id} order by id asc limit 1")
    public Article nextArticle(Integer id);

    @Select("select a.id,u.username from article a,user u where a.user_id = u.id;")
    public List<Map<String,String>> selectNameByArticle();
}
