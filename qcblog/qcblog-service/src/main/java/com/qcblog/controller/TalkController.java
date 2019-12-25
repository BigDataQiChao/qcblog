package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Talk;
import com.qcblog.service.TalkService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说说控制层
 * @author 赵起超
 * @Date 2019.10.23
 */
@Controller
@RequestMapping("/Talk")
public class TalkController {
    @Autowired
    private TalkService talkService;


    @RequestMapping("/findAll")
    @ResponseBody
    public List<Talk> findTalk(){
        return talkService.findTalks();
    }
    /**
     * 新增说说
     *
     * @param talk
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Talk talk) {
        if (talk.getTktitle() != null && talk.getTktitle() != "") {
            Talk TalkOne = talkService.findOne(talk.getTktitle());
            if (TalkOne != null) {
                talk.setTktitle(talk.getTktitle());
                talk.setCtime(new Date());
                try {
                    talkService.insert(talk);
                    return new Result(true, "新增成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return new Result(false, "新增的内容不存在！！！");
        } else {
            return new Result(false, "出现null漏洞！！！");
        }
    }
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows){
        return talkService.findPage(page, rows);
    }
    /**
     * 修改
     * @param talk
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Talk talk){
        try {
            talkService.update(talk);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer[] ids) {
        try {
            talkService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    /**
     * 单体删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public Result deleteUserOne(Integer id) {
        try {
            Talk talk = talkService.selectById(id);
            talk.setIsDelete("1");
            talkService.deleteOne(talk);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Talk talk, int page, int rows  ){
        return talkService.findPage(talk, page, rows);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Map countById(){
        String countTalk = talkService.countById();
        Map map = new HashMap<>();
        map.put("countTalk", countTalk);
        return map;
    }
    @RequestMapping("/up")
    @ResponseBody
    public Result upTalk(@Param("tktitle") String tktitle){
        Talk talk = talkService.findOne(tktitle);
        try{
            System.out.println("需要发布的说说："+talk.getTktitle());
            talk.setUtime(new Date());
            talk.setStatus("1");
            talk.setIsDelete("0");
            talkService.update(talk);
            return new Result(true, "发布成功");
        }catch (Exception e){
            return new Result(false, "发布失败");
        }
    }
    @RequestMapping("/down")
    @ResponseBody
    public Result downTalk(@Param("tktitle") String tktitle){
        Talk talk = talkService.findOne(tktitle);
        try{
            System.out.println("需要撤回的说说："+talk.getTktitle());
            talk.setUtime(new Date());
            talk.setStatus("0");
            talk.setIsDelete("0");
            talkService.update(talk);
            return new Result(true, "撤回成功");
        }catch (Exception e){
            return new Result(false, "撤回失败");
        }
    }
    /**
     * 通过tkTitle查询实体
     * @param tktitle
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public Talk findTalkOne(String tktitle){
        return talkService.findOne(tktitle);
    }
}
