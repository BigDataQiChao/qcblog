package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.LogMapper;
import com.qcblog.pojo.Signinlog;
import com.qcblog.pojo.SigninlogExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogMapper logMapper;
    public List<Signinlog> findSigninlogs() {
        return logMapper.selectByExample(null);
    }
    public void add(Signinlog Signinlog) {
        logMapper.insert(Signinlog);
    }

    public void insert(Signinlog signinlog) {
        logMapper.insert(signinlog);
    }

    public Signinlog findOne(Integer id) {
        return logMapper.selectById(id);
    }

    /**
     * 修改
     */
    public void update(Signinlog Signinlog) {
        logMapper.updateByPrimaryKey(Signinlog);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            logMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 单体删除
     *
     * @param Signinlog
     */
    public void deleteOne(Signinlog Signinlog) {
        logMapper.deleteOne(Signinlog);
    }

    /**
     * 删除主键
     */
    public void dropId() {
        logMapper.dropId();
    }
    /**
     * 新增主键
     */
    public void createId() {
        logMapper.createId();
    }
    /**
     * 重新排序
     */
    public void sortById() {
        logMapper.sortById();
    }
    /**
     * 通过ID 查询
     *
     * @return
     */
    public Signinlog selectById(Integer id) {
        return logMapper.selectByPrimaryKey(id);
    }

    public String countById() {
        return logMapper.countById();
    }

    public PageResult findPage(Signinlog signinlog, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SigninlogExample example = new SigninlogExample();
        SigninlogExample.Criteria criteria = example.createCriteria();
        if (signinlog != null) {
            if (signinlog.getLogname() != null && signinlog.getLogname().length() > 0) {
                criteria.andLognameLike("%" + signinlog.getLogname() + "%");
            }
            if (signinlog.getLogtype() != null && signinlog.getLogtype().length() > 0) {
                criteria.andLogtypeLike("%" + signinlog.getLogtype() + "%");
            }

            if (signinlog.getLogstatus() != null && signinlog.getLogstatus().length() > 0) {
                criteria.andLogstatusEqualTo(signinlog.getLogstatus());
            }
        }
        example.setOrderByClause("id desc");
        Page<Signinlog> page = (Page<Signinlog>) logMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SigninlogExample example = new SigninlogExample();
        example.setOrderByClause("id desc");
        Page<Signinlog> page = (Page<Signinlog>) logMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 条件查询
     */
    public Signinlog findLimitByName(String logname) {
        return logMapper.findLimitByName(logname);
    }

    /**
     * 条件查询
     */
    public List<Signinlog> findLogLimitByName(String logname) {
        return logMapper.findLogLimitByName(logname);
    }
}
