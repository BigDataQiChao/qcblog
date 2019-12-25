package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ntname;

    private String ntstatus;

    private String isDelete;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date ctime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date utime;

    private String nttype;

    private String ntcontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNtname() {
        return ntname;
    }

    public void setNtname(String ntname) {
        this.ntname = ntname == null ? null : ntname.trim();
    }

    public String getNtstatus() {
        return ntstatus;
    }

    public void setNtstatus(String ntstatus) {
        this.ntstatus = ntstatus == null ? null : ntstatus.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
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

    public String getNttype() {
        return nttype;
    }

    public void setNttype(String nttype) {
        this.nttype = nttype == null ? null : nttype.trim();
    }

    public String getNtcontent() {
        return ntcontent;
    }

    public void setNtcontent(String ntcontent) {
        this.ntcontent = ntcontent == null ? null : ntcontent.trim();
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", ntname='" + ntname + '\'' +
                ", ntstatus='" + ntstatus + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", nttype='" + nttype + '\'' +
                ", ntcontent='" + ntcontent + '\'' +
                '}';
    }
}