package com.qcblog.service;

import com.qcblog.mapper.LogMapper;
import com.qcblog.pojo.Signinlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogMapper logMapper;

    public void insert(Signinlog signinlog) {
        logMapper.insert(signinlog);
    }
    /**
     * 修改
     */
    public void update(Signinlog signinlog) {
        logMapper.updateByPrimaryKey(signinlog);
    }
    /**
     * 条件查询
     */
    public Signinlog findLimitByName(String logname){
        return logMapper.findLimitByName(logname);
    }
}
