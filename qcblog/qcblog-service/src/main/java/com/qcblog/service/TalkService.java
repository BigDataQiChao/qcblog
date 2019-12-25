package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.TalkMapper;
import com.qcblog.pojo.Talk;
import com.qcblog.pojo.TalkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkService {

    @Autowired
    private TalkMapper talkMapper;

    public List<Talk> findTalks(){
        return talkMapper.selectByExample(null);
    }
    public void add(Talk talk) {
        talkMapper.insert(talk);
    }


    public void insert(Talk talk){
        talkMapper.insert(talk);
    }
    public Talk findOne(String tktitle){
        return talkMapper.findByName(tktitle);
    }

    /**
     * 修改
     */
    public void update(Talk talk){
        talkMapper.updateByPrimaryKey(talk);
    }


    /**
     * 批量删除
     * @param ids
     */
    public void delete(Integer[] ids) {
        for(Integer id:ids){
            talkMapper.deleteByPrimaryKey(id);
        }
    }
    /**
     * 单体删除
     * @param talk
     */
    public void deleteOne(Talk talk) {
        talkMapper.deleteOne(talk);
    }
    /**
     * 通过ID 查询
     * @return
     */
    public Talk selectById(Integer id){
        return talkMapper.selectByPrimaryKey(id);
    }
    public String countById(){
        return talkMapper.countById();
    }

    public PageResult findPage(Talk talk, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TalkExample example=new TalkExample();
        TalkExample.Criteria criteria = example.createCriteria();
        if(talk!=null){
            if(talk.getTktitle()!=null && talk.getTktitle().length()>0){
                criteria.andTktitleLike("%"+talk.getTktitle()+"%");
            }
            if(talk.getTkcontent()!=null && talk.getTkcontent().length()>0){
                criteria.andTkcontentLike("%"+talk.getTkcontent()+"%");
            }

            if(talk.getStatus()!=null && talk.getStatus().length()>0){
                criteria.andStatusEqualTo(talk.getStatus());
            }
        }
        Page<Talk> page= (Page<Talk>)talkMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Talk> page = (Page<Talk>) talkMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
