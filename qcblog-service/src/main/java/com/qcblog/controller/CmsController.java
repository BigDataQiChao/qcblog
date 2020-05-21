package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.CmsContent;
import com.qcblog.pojo.Subject;
import com.qcblog.service.ArticleService;
import com.qcblog.service.CmsContentService;
import com.qcblog.service.SubjectService;
import com.qcblog.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Cms")
public class CmsController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别

    @Autowired
    private CmsContentService cmsContentService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有爬取文章数据资源
     *
     * @return
     */
    @RequestMapping("/findCmsAll")
    @ResponseBody
    public List<CmsContent> findCmsAll() {
        return cmsContentService.findCmsAll();
    }

    /**
     * 分页查询
     *
     * @param cmsContent
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody CmsContent cmsContent, int page, int rows) {
        return cmsContentService.findPage(cmsContent, page, rows);
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows) {
        return cmsContentService.findPage(page, rows);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer[] ids) {
        try {
            cmsContentService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            logger.error("/Cms/delete方法体异常，异常原因{}", e.getMessage());
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 根据ID 查询爬取的文章数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findCmsOne")
    @ResponseBody
    public CmsContent findCmsOne(String id) {
        return cmsContentService.findCmsOne(id);
    }

    /**
     * 文章去审核
     *
     * @param id
     * @return
     */
    @RequestMapping("/checkCms")
    @ResponseBody
    public Result checkCms(String id) {
        CmsContent cmsOne = cmsContentService.findCmsOne(id);
        Article article = new Article();
        article.setAtnumber(1);
        article.setLikenumber(0);
        article.setCtime(new Date());
        article.setAtcontent(cmsOne.getContent());
        article.setStatus("1");
        article.setIsDelete("0");
        article.setAtname(cmsOne.getTitle());
        if (cmsOne.getSubject() != null && cmsOne.getSubject() != "") {
            String[] pos = cmsOne.getSubject().split(",");
            article.setAtpos(pos[0]);
            article.setAtpre(pos[1]);
        }
        if (cmsOne.getTitle().length() > 9) {
            article.setSubtype("区块链专题");
        } else if (cmsOne.getTitle().length() > 5) {
            article.setSubtype("教育专题");
        } else {
            article.setSubtype("其他专题");
        }
        article.setAtlink(cmsOne.getUrl());
        article.setAtype("文章详情");
        article.setAtimg("img/slider/csdn.jpg");
        article.setUserId(1);
        try {
            cmsOne.setStatus("1");
            cmsContentService.updateCms(cmsOne);
            articleService.insert(article);
            int countUserId = userService.countByArticleUserId();
            userService.updateCarticnum(countUserId);
            Subject subject = new Subject();
            subject.setArticleId(article.getId());
            subject.setSubname(article.getSubtype());
            subject.setSubtype(article.getSubtype());
            subject.setStatus("1");
            subject.setUtime(new Date());
            subjectService.insertSub(subject);
            return new Result(true, "审核通过成功！");
        } catch (Exception e) {
            logger.error("/Cms/checkCms方法体异常，异常原因{}", e.getMessage());
            e.printStackTrace();
        }
        return new Result(false, "网络出现问题，请重新审核！！");
    }

    /**
     * 文章去驳回
     *
     * @param id
     * @return
     */
    @RequestMapping("/checkDownCms")
    @ResponseBody
    public Result checkDownCms(String id) {
        CmsContent cmsOne = cmsContentService.findCmsOne(id);
        Article article = articleService.findOne(cmsOne.getTitle());
        try {
            if (article != null) {
                cmsOne.setStatus("0");
                cmsContentService.updateCms(cmsOne);
                articleService.checkDelete(article);
                subjectService.deleteOne(article.getId());
                return new Result(true, "驳回成功！");
            }
        } catch (Exception e) {
            logger.error("/Cms/checkDownCms方法体异常，异常原因{}", e.getMessage());
            e.printStackTrace();
        }
        return new Result(false, "网络出现问题，请重新驳回！！");
    }
}
