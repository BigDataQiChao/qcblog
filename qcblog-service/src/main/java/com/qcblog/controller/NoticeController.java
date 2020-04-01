package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Notice;
import com.qcblog.service.NoticeService;
import io.lettuce.core.dynamic.annotation.Param;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公告控制层
 * @author 赵起超
 * @Date 2019.10.23
 */
@Controller
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Notice> findNotice(){
        return noticeService.findNotices();
    }
    /**
     * 新增公告
     *
     * @param notice
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Notice notice) {
        if (notice.getNtname() != null && notice.getNtname() != "") {
            Notice noticeOne = noticeService.findOne(notice.getNtname());
            if (noticeOne != null) {
                notice.setNtname(notice.getNtname());
                notice.setCtime(new Date());
                try {
                    noticeService.insert(notice);
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
        return noticeService.findPage(page, rows);
    }
    /**
     * 修改
     * @param notice
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Notice notice){
        try {
            notice.setIsDelete("0");
            notice.setUtime(new Date());
            noticeService.update(notice);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer[] ids) {
        try {
            noticeService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Notice notice, int page, int rows  ){
        return noticeService.findPage(notice, page, rows);
    }
    @RequestMapping("/count")
    @ResponseBody
    public Map countById(){
        String countNotice = noticeService.countById();
        Map map = new HashMap<>();
        map.put("countNotice", countNotice);
        return map;
    }
    @RequestMapping("/up")
    @ResponseBody
    public Result upNotice(@Param("ntname") String ntname){
        Notice notice = noticeService.findOne(ntname);
        try{
            System.out.println("需要发布的公告："+notice.getNtname());
            notice.setUtime(new Date());
            notice.setNtstatus("1");
            notice.setIsDelete("0");
            noticeService.update(notice);
            return new Result(true, "发布成功");
        }catch (Exception e){
            return new Result(false, "发布失败");
        }
    }
    @RequestMapping("/down")
    @ResponseBody
    public Result downNotice(@Param("ntname") String ntname){
        Notice notice = noticeService.findOne(ntname);
        try{
            System.out.println("需要撤回的公告："+notice.getNtname());
            notice.setUtime(new Date());
            notice.setNtstatus("0");
            notice.setIsDelete("0");
            noticeService.update(notice);
            return new Result(true, "撤回成功");
        }catch (Exception e){
            return new Result(false, "撤回失败");
        }
    }
    /**
     * 通过Noticetitle查询实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public Notice findNoticeOne(Integer id){
        return noticeService.findById(id);
    }
    /**
     * 标记已读状态
     *
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public Result updateNoticeStatus(@Param("id") Integer id){
        System.out.println("需要标记的ID："+id);
        try {
            Notice notice = noticeService.findById(id);
            notice.setNtstatus("2");
            noticeService.updateNoticeStatus(notice);
            return new Result(true, "标记已读！！！");
        }catch (Exception e){
            return new Result(false, "标记失败！！！");
        }
    }
    /**
     * 查找未读消息
     */
     @RequestMapping("/countByStatus")
     @ResponseBody
    public Map countByStatus(){
         String count = noticeService.countByStatus();
         Map map = new HashMap<>();
         map.put("countByStatus", count);
         return map;
     }

}
