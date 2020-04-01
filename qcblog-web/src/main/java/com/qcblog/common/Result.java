package com.qcblog.common;


import java.io.Serializable;

/**
 * 统一返回结果工具
 *
 * @author 赵起超
 * @date 2018.10.18
 */
public class Result implements Serializable {
    private Boolean success;//是否成功
    private String message;//返回信息


    public Result() {
    }

    /**
     * 构造器
     * @param success
     * @param message
     */
    public Result(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
