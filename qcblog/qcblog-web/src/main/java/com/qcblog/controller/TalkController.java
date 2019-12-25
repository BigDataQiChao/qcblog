package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Talk;
import com.qcblog.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Talk")
public class TalkController {
    @Autowired
    private TalkService talkService;

    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Talk talk) {
        if (talk.getTktitle() != null && talk.getTktitle() != " ") {
                try {
                    talk.setCtime(new Date());
                    talk.setStatus("1");
                    talk.setIsDelete("0");
                    talkService.add(talk);
                    return new Result(true, "新增成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return new Result(false, "修改的内容不存在！！！");
    }
    /**
     * 修改Talk
     *
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Talk talk) {
        try {
            talk.setUtime(new Date());
            talkService.update(talk);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    /**
     * 说说结果集
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Talk> findTalk() {
        return talkService.findAllList();
    }

    /**
     * 说说分页
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findTalkPage(int page, int rows) {
        return talkService.findPage(page, rows);
    }

    /**
     * 分页查询说说
     *
     * @param talk
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult searchTalk(Talk talk, int page, int rows) {
        return talkService.findPage(talk, page, rows);
    }

}
