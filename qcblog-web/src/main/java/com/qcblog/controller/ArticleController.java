package com.qcblog.controller;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.Talk;
import com.qcblog.pojo.User;
import com.qcblog.pojo.UserLike;
import com.qcblog.service.ArticleService;
import com.qcblog.service.TalkService;
import com.qcblog.service.UserLikeService;
import com.qcblog.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private UserService userService;

    @Autowired
    private UserLikeService userLikeService;

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
     * 文章作者信息
     */
    @RequestMapping("/findNames")
    @ResponseBody
    public List selectNameByArticle() {
        List list = new ArrayList();
        List<Map<String, String>> maps = articleService.selectNameByArticle();
        for (int i = 0; i < maps.size(); i++) {
            list.add(maps.get(i));
        }
        return list;
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
     * 发表文章
     */
    @RequestMapping("/addToArticle")
    @ResponseBody
    public Result addToArticle(@RequestBody Article article) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByName(name);
        System.out.println(name);
        if (article.getAtname() != null && article.getAtname() != "" && article.getAtcontent() != null && article.getAtcontent() != "") {
            try {
                article.setIsDelete("0");
                article.setCtime(new Date());
                article.setLikenumber(0);
                article.setAtnumber(1);
                article.setUserId(user.getId());
                articleService.insert(article);
                return new Result(true, "恭喜您，发表成功！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "网络出现问题，请重新发表！");
            }
        } else {
            return new Result(false, "有内容项为空，请重新发表！");
        }
    }

    /**
     * 文章类型查询
     */
    @RequestMapping("/findType")
    @ResponseBody
    public List<String> findType() {
        return articleService.findType();
    }

    /**
     * 文章前置标签查询
     */
    @RequestMapping("/findAtPre")
    @ResponseBody
    public List<String> findAtPre() {
        return articleService.findAtPre();
    }

    /**
     * 文章后置标签查询
     */
    @RequestMapping("/findAtPos")
    @ResponseBody
    public List<String> findAtPos() {
        return articleService.findAtPos();
    }

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Article article) {
        try {
            article.setIsDelete("0");
            articleService.insert(article);
            return new Result(true, "恭喜您，更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "网络出现问题，请重新尝试！");
        }
    }

    /**
     * 修改文章
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Article article) {
        try {
            article.setIsDelete("0");
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

    /**
     * 对文章进行点赞
     */
    @RequestMapping("/getlike")
    @ResponseBody
    public Result getlike(@RequestBody Integer id) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByName(name);
        UserLike userLike = userLikeService.findById(id, user.getId());
        if (userLike != null) {
            if (userLike.getStatus().equals("1")) {
                try {
                    userLike.setStatus("0");
                    userLikeService.update(userLike);
                    articleService.updateLikeNumber();
                    return new Result(true, "您已取消点赞！");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return new Result(false, "取消点赞失败哦！");
                }
            } else {
                try {
                    userLike.setStatus("1");
                    userLikeService.update(userLike);
                    articleService.updateLikeNumber();
                    return new Result(true, "您又恢复点赞啦，感谢亲！");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return new Result(false, "恢复点赞失败哦！");
                }
            }
        } else if (userLike == null) {
            try {
                UserLike userLike2 = new UserLike();
                userLike2.setStatus("1");
                userLike2.setEntityId(id);
                userLike2.setUserId(user.getId());
                userLikeService.insert(userLike2);
                articleService.updateLikeNumber();
                return new Result(true, "您成功点赞该文章！");
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Result(false, "点赞失败哦！");
            }
        }
        return new Result(false, "方法体异常！");
    }

    /**
     * 点赞状态码
     * @return
     */
    @RequestMapping("/findStatus")
    @ResponseBody
    public List findStatus() {
        List list = new ArrayList();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByName(name);
        List<Map<String, String>> userLikeServiceStatus = userLikeService.findStatus(user.getId());
        for (int i = 0; i < userLikeServiceStatus.size(); i++) {
            list.add(userLikeServiceStatus.get(i));
        }
        return list;
    }

    /**
     * 通过ID查询
     */
    @RequestMapping("/findById")
    @ResponseBody
    public Article findById(@Param("id") Integer id) {
        return articleService.findById(id);
    }
}


