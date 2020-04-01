package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String atname;

    private Integer atnumber;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date ctime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date utime;

    private String atpre;

    private String atpos;

    private String atimg;

    private String atlink;

    private String status;

    private String isDelete;

    private String atype;

    private String atcontent;
    private Integer likenumber;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAtname() {
        return atname;
    }

    public void setAtname(String atname) {
        this.atname = atname == null ? null : atname.trim();
    }

    public Integer getAtnumber() {
        return atnumber;
    }

    public void setAtnumber(Integer atnumber) {
        this.atnumber = atnumber;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getAtpre() {
        return atpre;
    }

    public void setAtpre(String atpre) {
        this.atpre = atpre == null ? null : atpre.trim();
    }

    public String getAtpos() {
        return atpos;
    }

    public void setAtpos(String atpos) {
        this.atpos = atpos == null ? null : atpos.trim();
    }

    public String getAtimg() {
        return atimg;
    }

    public void setAtimg(String atimg) {
        this.atimg = atimg == null ? null : atimg.trim();
    }

    public String getAtlink() {
        return atlink;
    }

    public void setAtlink(String atlink) {
        this.atlink = atlink == null ? null : atlink.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype == null ? null : atype.trim();
    }

    public String getAtcontent() {
        return atcontent;
    }

    public void setAtcontent(String atcontent) {
        this.atcontent = atcontent == null ? null : atcontent.trim();
    }

    public Integer getLikenumber() {
        return likenumber;
    }

    public void setLikenumber(Integer likenumber) {
        this.likenumber = likenumber;
    }
}