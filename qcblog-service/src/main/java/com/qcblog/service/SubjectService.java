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

    public void insertSub(Subject subject){
        subjectMapper.insert(subject);
    }

    public void deleteOne(Integer id){
        subjectMapper.deleteOne(id);
    }
}
