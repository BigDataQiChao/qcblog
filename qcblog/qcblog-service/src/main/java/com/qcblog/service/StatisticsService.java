package com.qcblog.service;

import com.qcblog.mapper.*;
import com.qcblog.pojo.Numbers;
import com.qcblog.pojo.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.AAShapePipe;

import java.util.Date;

@Service
public class StatisticsService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private FlinkMapper flinkMapper;

    @Autowired
    private TalkMapper talkMapper;

    @Autowired
    private RecreationMapper recreationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NumbersMapper numbersMapper;

    @Autowired
    private StatisticsMapper statisticsMapper;

    public Statistics updateStatistics(Integer id){
        Integer articles = Integer.parseInt(articleMapper.countById());
        Integer notices = Integer.parseInt(noticeMapper.countById());
        Integer flinks = Integer.parseInt(flinkMapper.countById());
        Integer talks = Integer.parseInt(talkMapper.countById());
        Integer recreations = Integer.parseInt(recreationMapper.countById());
        Integer users = Integer.parseInt(userMapper.countById());
        Numbers numbers = numbersMapper.selectByPrimaryKey(1);
        Integer nums = numbers.getWnumber();
        Statistics statistics = statisticsMapper.selectById(id);
        if(statistics!=null){
            statistics.setArticleNum(articles);
            statistics.setNoticeNum(notices);
            statistics.setFlinkNum(flinks);
            statistics.setTalkNum(talks);
            statistics.setGameNum(recreations);
            statistics.setUserNum(users);
            statistics.setNums(nums);
            statistics.setStdate(new Date());
            statistics.setQcblogNum(articles+notices+flinks+talks+recreations+users);
            statisticsMapper.updateByPrimaryKey(statistics);
        }
        return statistics;
    }
    public Statistics findOne(Integer id){
        return statisticsMapper.selectById(id);
    }
}
