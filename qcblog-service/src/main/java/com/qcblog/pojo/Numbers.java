package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "numbers")
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tnumber;

    private Integer wnumber;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date ctime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date utime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTnumber() {
        return tnumber;
    }

    public void setTnumber(Integer tnumber) {
        this.tnumber = tnumber;
    }

    public Integer getWnumber() {
        return wnumber;
    }

    public void setWnumber(Integer wnumber) {
        this.wnumber = wnumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "id=" + id +
                ", tnumber=" + tnumber +
                ", wnumber=" + wnumber +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", status='" + status + '\'' +
                '}';
    }
}