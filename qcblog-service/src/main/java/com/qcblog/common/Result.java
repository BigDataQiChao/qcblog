package com.qcblog.common;

import java.io.Serializable;
/**
 * 通用返回值类
 * @author 赵起超
 * @date 2020.01.15
 */
public class Result implements Serializable{
	//是否成功
	private Boolean success;
	//返回信息
	private String message;

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
