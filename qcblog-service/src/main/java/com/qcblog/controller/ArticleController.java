package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Article;
import com.qcblog.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章控制层
 * @author 赵起超
 * @date 2019.10.23
 */
@Controller
@RequestMapping("/Article")
public class ArticleController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Article> findArticle(){
        return articleService.findArticles();
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
                    logger.error("/Article/add方法体异常，异常原因{}",e.getMessage());
                    e.printStackTrace();
                }
            }
            return new Result(false, "修改的内容不存在！！！");
        } else {
            return new Result(false, "出现null漏洞！！！");
        }
    }
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows){
        return articleService.findPage(page, rows);
    }
    /**
     * 修改
     * @param article
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Article article){
        try {
            article.setUtime(new Date());
            article.setIsDelete("0");
            articleService.update(article);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            logger.error("/Article/update方法体异常，异常原因{}",e.getMessage());
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer[] ids) {
        try {
            articleService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            logger.error("/Article/delete方法体异常，异常原因{}",e.getMessage());
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    /**
     * 单个删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public Result deleteUserOne(Integer id) {
        try {
            Article article = articleService.selectById(id);
            article.setIsDelete("1");
            articleService.deleteOne(article);
            return new Result(true, "删除成功");
        } catch (Exception e) {

            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 分页查询
     * @param article
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Article article, int page, int rows  ){
        return articleService.findPage(article, page, rows);
    }

    /**
     * 查询文章总数
     * @return
     */
    @RequestMapping("/count")
    @ResponseBody
    public Map countById(){
        String countArticle = articleService.countById();
        Map map = new HashMap<>();
        map.put("countArticle", countArticle);
        return map;
    }

    /**
     * 发布文章
     * @param atname
     * @return
     */
    @RequestMapping("/up")
    @ResponseBody
    public Result upArticle(@Param("atname") String atname){
        Article article = articleService.findOne(atname);
        try{
            System.out.println("需要发布的文章："+article.getAtname());
            article.setStatus("1");
            article.setIsDelete("0");
            article.setUtime(new Date());
            articleService.update(article);
            return new Result(true, "发布成功");
        }catch (Exception e){
            logger.error("/Article/up方法体异常，异常原因{}",e.getMessage());
            return new Result(false, "发布失败");
        }
    }

    /**
     * 下架文章
     * @param atname
     * @return
     */
    @RequestMapping("/down")
    @ResponseBody
    public Result downArticle(@Param("atname") String atname){
        Article article = articleService.findOne(atname);
        try{
            article.setStatus("0");
            article.setIsDelete("0");
            article.setUtime(new Date());
            articleService.update(article);
            return new Result(true, "撤回成功");
        }catch (Exception e){
            logger.error("/Article/down方法体异常，异常原因{}",e.getMessage());
            return new Result(false, "撤回失败");
        }
    }
    /**
     * 通過name查詢实体
     * @param atname
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public Article findOne(String atname){
        return articleService.findOne(atname);
    }
    /**
     * 通過id查詢实体
     * @param id
     * @return
     */
    @RequestMapping("/updateArticleOne")
    @ResponseBody
    public Article selectArticleOne(Integer id){
        Article article = articleService.selectById(id);
        System.out.println("去修改文章名："+article.getAtname());
        return articleService.selectArticleOne(id);
    }
}
