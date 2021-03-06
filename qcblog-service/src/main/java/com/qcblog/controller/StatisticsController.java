package com.qcblog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qcblog.pojo.Statistics;
import com.qcblog.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 统计报告控制层
 * @author 赵起超
 * @Date 2020.1.15
 */
@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    /**
     * 数据报告统计
     * @return
     */
    @RequestMapping("/statistics")
    @ResponseBody
    public Map signinStatistics(){
        Map map = new HashMap<>();
        Statistics updateStatistics = statisticsService.updateStatistics(1);
        map.put("articleNum", updateStatistics.getArticleNum());
        map.put("noticeNum", updateStatistics.getNoticeNum());
        map.put("flinkNum", updateStatistics.getFlinkNum());
        map.put("talkNum", updateStatistics.getTalkNum());
        map.put("gameNum", updateStatistics.getGameNum());
        map.put("userNum", updateStatistics.getUserNum());
        map.put("numbers", updateStatistics.getNums());
        map.put("qcblogNum", updateStatistics.getQcblogNum());
        Integer flow = updateStatistics.getQcblogNum() + updateStatistics.getNums();
        map.put("flow", flow);
        return  map;
    }

    /**
     * 饼图数据回显
     * @return
     */
    @RequestMapping("/getPieData")
    @ResponseBody
    public List getBingData(){
        Statistics updateStatistics = statisticsService.updateStatistics(1);
        String data ="[{value:"+updateStatistics.getUserNum()+",name:'平台用户'},{value:"
                +updateStatistics.getArticleNum()+",name:'技术文章'},{value:"+updateStatistics.getTalkNum()+",name:'个性说说'},{value:"
                +updateStatistics.getFlinkNum()+",name:'友情链接'},{value:"+updateStatistics.getNoticeNum()+",name:'通知公告'},{value:"
                +updateStatistics.getGameNum()+",name:'小程序'}]";
        return JSON.parseArray(data);
    }

    /**
     * 条形图数据回显
     * @return
     */
    @RequestMapping("/getHistogram")
    @ResponseBody
    public List getHistogram(){
        Statistics updateStatistics = statisticsService.updateStatistics(1);
        String data ="["+updateStatistics.getQcblogNum()+","+updateStatistics.getNums()+"]";
        return JSON.parseArray(data);
    }
}
