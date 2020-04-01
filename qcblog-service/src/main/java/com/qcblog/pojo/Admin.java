package com.qcblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String adminName;
    private String adminPassword;
    private Integer isDelete;
    private Integer status;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date signintime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private Date sigouttime;
    private Integer isSuperadmin;

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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSignintime() {
        return signintime;
    }

    public void setSignintime(Date signintime) {
        this.signintime = signintime;
    }

    public Date getSigouttime() {
        return sigouttime;
    }

    public void setSigouttime(Date sigouttime) {
        this.sigouttime = sigouttime;
    }

    public Integer getIsSuperadmin() {
        return isSuperadmin;
    }

    public void setIsSuperadmin(Integer isSuperadmin) {
        this.isSuperadmin = isSuperadmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userId=" + userId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", isDelete=" + isDelete +
                ", status=" + status +
                ", signintime=" + signintime +
                ", sigouttime=" + sigouttime +
                ", isSuperadmin=" + isSuperadmin +
                '}';
    }
}
