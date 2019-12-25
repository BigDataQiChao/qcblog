package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.common.UploadUtils;
import com.qcblog.mapper.TalkMapper;
import com.qcblog.pojo.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class TalkService {

    @Autowired
    private TalkMapper talkMapper;

    public List<Talk> findAllList() {
        return talkMapper.selectByExample(null);
    }

    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Talk> page = (Page<Talk>) talkMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public PageResult findPage(Talk talk, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Talk> page = (Page<Talk>) talkMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public void add(Talk talk) {
        talk.setCtime(new Date());
        talk.setTklink("www.zqcgo.cn");
        talk.setStatus("1");
        talk.setIsDelete("0");
        talkMapper.insert(talk);
    }

    public void update(Talk talk) {
        talk.setTklink("www.zqcgo.cn");
        Talk talks = talkMapper.selectByPrimaryKey(talk.getId());
        if (talks.getTkcontent() != null && talks.getTkcontent() != "") {
            talkMapper.updateByExample(talk, Talk.class);
        }
    }
}
