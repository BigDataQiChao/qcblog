package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "attention")
public class Attention implements Serializable{
    private Integer id;

    private Integer focusId;

    private String focusName;

    private Integer focusedId;

    private String focusedName;

    private String status;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date utime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFocusId() {
        return focusId;
    }

    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }

    public String getFocusName() {
        return focusName;
    }

    public void setFocusName(String focusName) {
        this.focusName = focusName;
    }

    public Integer getFocusedId() {
        return focusedId;
    }

    public void setFocusedId(Integer focusedId) {
        this.focusedId = focusedId;
    }

    public String getFocusedName() {
        return focusedName;
    }

    public void setFocusedName(String focusedName) {
        this.focusedName = focusedName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Attention{" +
                "id=" + id +
                ", focusId=" + focusId +
                ", focusName='" + focusName + '\'' +
                ", focusedId=" + focusedId +
                ", focusedName='" + focusedName + '\'' +
                ", status='" + status + '\'' +
                ", utime=" + utime +
                ", ctime=" + ctime +
                '}';
    }
}
