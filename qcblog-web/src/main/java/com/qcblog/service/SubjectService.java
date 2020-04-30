package com.qcblog.service;

import com.qcblog.mapper.SubjectMapper;
import com.qcblog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 根据专题分类查询文章内容
     * @param subname
     * @return
     */
    public List<Article> findArticleBySubType(String subname){
        return subjectMapper.findArticleBySubType(subname);
    }
}
