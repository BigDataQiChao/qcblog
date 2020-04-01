package com.qcblog.controller;

import com.qcblog.pojo.Notice;
import com.qcblog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/listAll")
    @ResponseBody
    public List<Notice> listAll(){
        List<Notice> allList = noticeService.findAllList();
        return noticeService.findAllList();
    }

}
