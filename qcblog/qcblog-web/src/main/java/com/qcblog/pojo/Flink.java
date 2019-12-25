package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flink")
public class Flink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String flname;

    private String flink;

    private String flstatus;

    private String isDelete;

    private String flcontent;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date ctime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date utime;

    private String fltype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname == null ? null : flname.trim();
    }

    public String getFlink() {
        return flink;
    }

    public void setFlink(String flink) {
        this.flink = flink == null ? null : flink.trim();
    }

    public String getFlstatus() {
        return flstatus;
    }

    public void setFlstatus(String flstatus) {
        this.flstatus = flstatus == null ? null : flstatus.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getFlcontent() {
        return flcontent;
    }

    public void setFlcontent(String flcontent) {
        this.flcontent = flcontent == null ? null : flcontent.trim();
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

    public String getFltype() {
        return fltype;
    }

    public void setFltype(String fltype) {
        this.fltype = fltype == null ? null : fltype.trim();
    }

    @Override
    public String toString() {
        return "Flink{" +
                "id=" + id +
                ", flname='" + flname + '\'' +
                ", flink='" + flink + '\'' +
                ", flstatus='" + flstatus + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", flcontent='" + flcontent + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", fltype='" + fltype + '\'' +
                '}';
    }
}