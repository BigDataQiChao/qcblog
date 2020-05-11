package com.qcblog.service;

import com.qcblog.mapper.SubjectMapper;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.Subject;
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

    public List<String>  findSubName(){
        return subjectMapper.findSubName();
    }

    public void insertSub(Subject subject){
        subjectMapper.insert(subject);
    }
}
