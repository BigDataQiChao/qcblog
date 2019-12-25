package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.NoticeMapper;
import com.qcblog.pojo.Notice;
import com.qcblog.pojo.NoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    public List<Notice> findNotices(){
        return noticeMapper.selectByExample(null);
    }
    public void add(Notice notice) {
        noticeMapper.insert(notice);
    }


    public void insert(Notice notice){
        noticeMapper.insert(notice);
    }
    public Notice findOne(String ntname){
        return noticeMapper.findByName(ntname);
    }
    public Notice findById(Integer id){
        return noticeMapper.findById(id);
    }
    /**
     * 修改
     */
    public void update(Notice notice){
        noticeMapper.updateByPrimaryKey(notice);
    }


    public void delete(Integer[] ids) {
        for(Integer id:ids){
            noticeMapper.deleteByPrimaryKey(id);
        }
    }

    public String countById(){
        return noticeMapper.countById();
    }
    public PageResult findPage(Notice notice, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        NoticeExample example=new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        if(notice!=null){
            if(notice.getNtname()!=null && notice.getNtname().length()>0){
                criteria.andNtnameLike("%"+notice.getNtname()+"%");
            }
            if(notice.getNtstatus()!=null && notice.getNtstatus().length()>0){
                criteria.andNtstatusEqualTo(notice.getNtstatus());
            }
        }
        Page<Notice> page= (Page<Notice>)noticeMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Notice> page = (Page<Notice>) noticeMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
