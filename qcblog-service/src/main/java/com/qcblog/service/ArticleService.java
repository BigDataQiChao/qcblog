package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.ArticleMapper;
import com.qcblog.pojo.Admin;
import com.qcblog.pojo.AdminExample;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.ArticleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> findArticles(){
        return articleMapper.selectByExample(null);
    }
    public void add(Article article) {
        articleMapper.insert(article);
    }


    public void insert(Article article){
        articleMapper.insert(article);
    }
    public Article findOne(String atName){
        return articleMapper.selectByName(atName);
    }
    public Article selectArticleOne(Integer id){
        return articleMapper.selectById(id);
    }
    /**
     * 修改
     */
    public void update(Article article){
        articleMapper.updateByPrimaryKey(article);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Integer[] ids) {
        for(Integer id:ids){
            articleMapper.deleteByPrimaryKey(id);
        }
    }
    /**
     * 单体删除
     * @param article
     */
    public void deleteOne(Article article) {
        articleMapper.deleteOne(article);
    }
    /**
     * 通过ID 查询
     * @return
     */
    public Article selectById(Integer id){
        return articleMapper.selectByPrimaryKey(id);
    }
    public String countById(){
        return articleMapper.countById();
    }

    public PageResult findPage(Article article, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample example=new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        if(article!=null){
            if(article.getAtname()!=null && article.getAtname().length()>0){
                criteria.andAtnameLike("%"+article.getAtname()+"%");
            }
            if(article.getAtlink()!=null && article.getAtlink().length()>0){
                criteria.andAtlinkLike("%"+article.getAtlink()+"%");
            }

            if(article.getStatus()!=null && article.getStatus().length()>0){
                criteria.andStatusEqualTo(article.getStatus());
            }
        }
        Page<Article> page= (Page<Article>)articleMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Article> page = (Page<Article>) articleMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public void checkDelete(Article article){
        articleMapper.checkDelete(article);
    }
}
