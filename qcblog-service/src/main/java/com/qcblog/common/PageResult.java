package com.qcblog.common;
/**
 * 分页结果类
 * @author 赵起超
 * @date 2020.01.15
 */
import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
	//总记录数
	private Long total;
	//当前页记录 不知到传入的是什么，不指定泛型
	private List rows;
	public PageResult(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
