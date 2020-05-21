package com.qcblog.controller;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.*;
import com.qcblog.service.*;
import com.qcblog.utils.FileUtils;
import com.qcblog.utils.PoiUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserLikeService userLikeService;

    @Autowired
    private SubjectService subjectService;

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
        try{
            List<Map<String, String>> maps = articleService.selectNameByArticle();
            for (int i = 0; i < maps.size(); i++) {
                list.add(maps.get(i));
            }
            logger.info("作者信息查询成功，信息如→{}", list.toString());
        }catch (Exception e){
            logger.error("/Article/findNames方法体异常，原因如→{}",e.getMessage());
            e.printStackTrace();
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
                int countUserId = userService.countByArticleUserId(name);
                userService.updateCarticnum(countUserId, name);
                Subject subject = new Subject();
                subject.setArticleId(article.getId());
                subject.setSubname(article.getSubtype());
                subject.setSubtype(article.getSubtype());
                subject.setStatus("1");
                subject.setUtime(new Date());
                subjectService.insertSub(subject);
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

    /**
     * 博苑主页推荐文章
     * @return
     */
    @RequestMapping("/findIndexArticle")
    @ResponseBody
    public List<Article> findIndexArticle(){
        return articleService.findIndexArticle();
    }

    /**
     * 导出单个文章
     * @param atname
     * @param response
     * @throws IOException
     */
    @GetMapping("/exportArticleOne")
    public void exportArticleOne(String atname,HttpServletResponse response){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("文章详情表");
        Article article = articleService.findOne(atname);
        System.out.println("要导出的文章名称："+atname);
        User outhor = userService.findArticleOneOuthor(article.getUserId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fileName = "IT_boyuan_article_"+article.getId(); //导出文件名
        //headers表示excel表中第一行的表头
        String[] headers = { "序号", "文章名称", "所属用户", "文章内容","前置标签","后置标签","专题类型","点赞数","发表时间","访问量","文章来源"};
        //在excel表中添加表头
        Row row = sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            Cell cell = row.createCell(i);
            RichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(article.getId());
        row1.createCell(1).setCellValue(article.getAtname());
        row1.createCell(2).setCellValue(outhor.getUsername());
        row1.createCell(3).setCellValue(article.getAtcontent());
        row1.createCell(4).setCellValue(article.getAtpre());
        row1.createCell(5).setCellValue(article.getAtpos());
        row1.createCell(6).setCellValue(article.getSubtype());
        row1.createCell(7).setCellValue(article.getLikenumber());
        row1.createCell(8).setCellValue(sdf.format(article.getCtime()));
        row1.createCell(9).setCellValue(article.getAtnumber());
        row1.createCell(10).setCellValue(article.getAtlink());

        File file = PoiUtils.createExcelFile(workbook, fileName);
        FileUtils.downloadFile(response, file, file.getName());
    }
}


