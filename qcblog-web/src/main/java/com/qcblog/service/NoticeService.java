package com.qcblog.service;

import com.qcblog.mapper.NoticeMapper;
import com.qcblog.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 遍历所有公告
     * @return
     */
    public List<Notice> findAllList(){
        return noticeMapper.selectByExample(null);
    }


}
