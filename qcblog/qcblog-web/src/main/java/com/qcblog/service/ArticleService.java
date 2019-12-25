package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.ArticleMapper;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.ArticleExample;
import com.qcblog.pojo.ArticleExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 遍历所有文章
     * @return
     */
    public List<Article> findAllList(){
       return articleMapper.selectByExample(null);
    }

    /**
     *  分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<Article> page= (Page<Article>)articleMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 分页查询
     * @param article
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(Article article,int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample example=new ArticleExample();
        Criteria criteria = example.createCriteria();
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
     * 查询文章实体
     * @return
     */
    public Article findOne(String atName){
        return articleMapper.findByName(atName);
    }

    /**
     * 查询文章实体2
     * @return
     */
    public Article findName(String atName){
        return articleMapper.findByName(atName);
    }
    /**
     * 插入文章
     */
    public void insert(Article article){
        articleMapper.insert(article);
    }


    /**
     *  修改文章
     *
     */
    public void update(Article article){
        articleMapper.updateByPrimaryKey(article);
    }

    /**
     * 文章访问量
     *
     */
    public void upateArticles(Article article){
        articleMapper.updateArticle(article);
    }

    /**
     * 上一篇
     *
     */
    public Article getPre(Integer id){
        return articleMapper.preArticle(id);
    }


    /**
     * 下一篇
     *
     */
    public Article getNext(Integer id){
        return articleMapper.nextArticle(id);
    }

    /**
     *  通过ID查询
     */
    public Article selectOne(Integer id){
        return articleMapper.selectByPrimaryKey(id);
    }
}
