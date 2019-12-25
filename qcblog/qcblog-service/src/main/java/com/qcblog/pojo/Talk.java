package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "talk")
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tktitle;

    private String tkcontent;

    private String tkimg;

    private String tklink;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date ctime;

    private String status;

    private String isDelete;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date utime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTktitle() {
        return tktitle;
    }

    public void setTktitle(String tktitle) {
        this.tktitle = tktitle == null ? null : tktitle.trim();
    }

    public String getTkcontent() {
        return tkcontent;
    }

    public void setTkcontent(String tkcontent) {
        this.tkcontent = tkcontent == null ? null : tkcontent.trim();
    }

    public String getTkimg() {
        return tkimg;
    }

    public void setTkimg(String tkimg) {
        this.tkimg = tkimg == null ? null : tkimg.trim();
    }

    public String getTklink() {
        return tklink;
    }

    public void setTklink(String tklink) {
        this.tklink = tklink == null ? null : tklink.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
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

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id=" + id +
                ", tktitle='" + tktitle + '\'' +
                ", tkcontent='" + tkcontent + '\'' +
                ", tkimg='" + tkimg + '\'' +
                ", tklink='" + tklink + '\'' +
                ", ctime=" + ctime +
                ", status='" + status + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", utime=" + utime +
                '}';
    }
}