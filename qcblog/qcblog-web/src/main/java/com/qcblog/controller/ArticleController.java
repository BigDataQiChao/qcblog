package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.Talk;
import com.qcblog.service.ArticleService;
import com.qcblog.service.TalkService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 文章控制层
 *
 * @author 赵起超
 */
@Controller
@RequestMapping("/Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章结果集
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Article> findArticle() {
        return articleService.findAllList();
    }

    /**
     * 分页结果
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows) {
        return articleService.findPage(page, rows);
    }

    /**
     * 分页查询
     *
     * @param article
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Article article, int page, int rows) {
        return articleService.findPage(article, page, rows);
    }

    /**
     * 查询单个文章
     *
     * @param atname
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public Article findOne(String atname) {
        return articleService.findOne(atname);
    }

    /**
     * 根据文章名称查询
     *
     * @param atname
     * @return
     */
    @RequestMapping("/findName")
    @ResponseBody
    public Article findName(String atname) {
        return articleService.findName(atname);
    }

    /**
     * 插入文章
     *
     * @param article
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Article article) {
        if (article.getAtname() != null && article.getAtname() != "") {
            Article articleByName = articleService.findOne(article.getAtname());
            if (articleByName != null) {
                article.setAtname(article.getAtname());
                article.setCtime(new Date());
                article.setAtnumber(article.getAtnumber());
                try {
                    articleService.insert(article);
                    return new Result(true, "修改成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return new Result(false, "修改的内容不存在！！！");
        } else {
            return new Result(false, "出现null漏洞！！！");
        }
    }

    /**
     * 修改文章
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Article article) {
        try {
            articleService.update(article);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取上一篇文章
     */
    @RequestMapping("/getPre")
    @ResponseBody
    public Article getPreArticle(@Param("atname") String atname) {
        Article articles = articleService.findOne(atname);
        return articleService.getPre(articles.getId());
    }
    /**
     * 获取下一篇文章
     */
    @RequestMapping("/getNext")
    @ResponseBody
    public Article getNextArticle(@Param("atname") String atname) {
        Article articles = articleService.findOne(atname);
        return articleService.getNext(articles.getId());
    }
}


