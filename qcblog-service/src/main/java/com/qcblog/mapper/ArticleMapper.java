package com.qcblog.mapper;

import com.qcblog.pojo.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface ArticleMapper extends Mapper<Article> {
    @Select("select count(*) from article where is_delete = 0")
    public String countById();
    @Select("select * from article where atname = #{atname}")
    public Article selectByName(String atname);
    @Select("select * from article where id = #{id}")
    public Article selectById(Integer id);
    @Update("update article set status = #{status}, is_delete = #{isDelete} where id = #{id}")
    public void updateStatus(Article article);
    @Update("update article set is_delete = #{isDelete} where id = #{id}")
    public void deleteOne(Article article);
    @Delete("delete from article where id = #{id}")
    public void checkDelete(Article article);
}
