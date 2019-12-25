package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.Flink;
import com.qcblog.service.FlinkService;
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
 * 友链控制层
 * @author 赵起超
 * @Date 2019.10.23
 */
@Controller
@RequestMapping("/Flink")
public class FilnkController {
    @Autowired
    private FlinkService flinkService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Flink> findFlink(){
        return flinkService.findFlinks();
    }
    /**
     * 插入友链
     *
     * @param flink
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Flink flink) {
        if (flink.getFlname() != null && flink.getFlname() != "") {
            Flink flinkOne = flinkService.findOne(flink.getFlname());
            if (flinkOne != null) {
                flink.setFlname(flink.getFlname());
                flink.setCtime(new Date());
                try {
                    flinkService.insert(flink);
                    return new Result(true, "新增成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return new Result(false, "修改的内容不存在！！！");
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
        return flinkService.findPage(page, rows);
    }
    /**
     * 修改
     * @param flink
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Flink flink){
        try {
            flinkService.update(flink);
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
            flinkService.delete(ids);
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
            Flink flink = flinkService.selectById(id);
            flink.setIsDelete("1");
            flinkService.deleteOne(flink);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Flink flink, int page, int rows  ){
        return flinkService.findPage(flink, page, rows);
    }

    @RequestMapping("/count")
    @ResponseBody
    public Map countById(){
        String countFlink = flinkService.countById();
        Map map = new HashMap<>();
        map.put("countFlink", countFlink);
        return map;
    }
    @RequestMapping("/up")
    @ResponseBody
    public Result upFlink(@Param("flname") String flname){
        Flink flink = flinkService.findOne(flname);
        try{
            System.out.println("需要发布的链接："+flink.getFlname());
            flink.setUtime(new Date());
            flink.setFlstatus("1");
            flink.setIsDelete("0");
            flinkService.update(flink);
            return new Result(true, "发布成功");
        }catch (Exception e){
            return new Result(false, "发布失败");
        }
    }
    @RequestMapping("/down")
    @ResponseBody
    public Result downFlink(@Param("flname") String flname){
        Flink flink = flinkService.findOne(flname);
        try{
            System.out.println("需要撤回的链接："+flink.getFlname());
            flink.setUtime(new Date());
            flink.setFlstatus("0");
            flink.setIsDelete("0");
            flinkService.update(flink);
            return new Result(true, "撤回成功");
        }catch (Exception e){
            return new Result(false, "撤回失败");
        }
    }
    /**
     * 通过name查询实体
     * @param name
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public Flink findOne(String name){
        return flinkService.findOne(name);
    }
}
