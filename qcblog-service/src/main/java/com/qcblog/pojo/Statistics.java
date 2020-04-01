package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer qcblogNum;
    private Integer articleNum;
    private Integer noticeNum;
    private Integer flinkNum;
    private Integer talkNum;
    private Integer gameNum;
    private Integer userNum;
    private Integer nums;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date stdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQcblogNum() {
        return qcblogNum;
    }

    public void setQcblogNum(Integer qcblogNum) {
        this.qcblogNum = qcblogNum;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(Integer noticeNum) {
        this.noticeNum = noticeNum;
    }

    public Integer getFlinkNum() {
        return flinkNum;
    }

    public void setFlinkNum(Integer flinkNum) {
        this.flinkNum = flinkNum;
    }

    public Integer getTalkNum() {
        return talkNum;
    }

    public void setTalkNum(Integer talkNum) {
        this.talkNum = talkNum;
    }

    public Integer getGameNum() {
        return gameNum;
    }

    public void setGameNum(Integer gameNum) {
        this.gameNum = gameNum;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Date getStdate() {
        return stdate;
    }

    public void setStdate(Date stdate) {
        this.stdate = stdate;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", qcblogNum=" + qcblogNum +
                ", articleNum=" + articleNum +
                ", noticeNum=" + noticeNum +
                ", flinkNum=" + flinkNum +
                ", talkNum=" + talkNum +
                ", gameNum=" + gameNum +
                ", userNum=" + userNum +
                ", nums=" + nums +
                ", stdate=" + stdate +
                '}';
    }
}
