package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Signinlog;
import com.qcblog.service.LogService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录日志控制层
 * @author 赵起超
 * @Date 2019.10.28
 */
@Controller
@RequestMapping("/Log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Signinlog> findSigninlogs(){
        return logService.findSigninlogs();
    }
    /**
     * 分页
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows){
        return logService.findPage(page, rows);
    }
    /**
     * 修改
     * @param signinlog
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Signinlog signinlog){
        try {
            signinlog.setUtime(new Date());
            logService.update(signinlog);
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
            logService.delete(ids);
            //删除后重新对自增主键重新排序
            logService.dropId();
            logService.createId();
            logService.sortById();
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
            Signinlog signinlog = logService.selectById(id);
            signinlog.setIsDelete("1");
            logService.deleteOne(signinlog);
            //删除后重新对自增主键重新排序
            logService.dropId();
            logService.createId();
            logService.sortById();
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 分页查询
     * @param Signinlog
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Signinlog Signinlog, int page, int rows  ){
        return logService.findPage(Signinlog, page, rows);
    }

    /**
     * 查询日志总数
     * @return
     */
    @RequestMapping("/count")
    @ResponseBody
    public Map countById(){
        String countSigninlog = logService.countById();
        Map map = new HashMap<>();
        map.put("countSigninlog", countSigninlog);
        return map;
    }
    /**
     * 通過id查詢实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public Signinlog findOne(Integer id){
        return logService.findOne(id);
    }

    /**
     * 通过lognameLimt 查询实体
     * @param logname
     * @return
     */
    @RequestMapping("/findLogs")
    @ResponseBody
    public List<Signinlog> findLogs(String logname){
        return logService.findLogLimitByName(logname);
    }
}
