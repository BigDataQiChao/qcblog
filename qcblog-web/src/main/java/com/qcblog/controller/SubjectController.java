package com.qcblog.controller;

import com.qcblog.pojo.Article;
import com.qcblog.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 根据专题分类查询文章内容
     * @param subname
     * @return
     */
    @RequestMapping("/findSubList")
    @ResponseBody
    public List<Article>  findArticleBySubType(@RequestBody String subname){
        System.out.println("专题分类名称：-------"+subname);
        return subjectService.findArticleBySubType(subname);
    }
}
