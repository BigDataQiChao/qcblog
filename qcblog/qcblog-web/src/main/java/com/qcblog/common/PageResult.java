package com.qcblog.common;


import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 *
 * @author 赵起超
 * @date 2018.10.18
 */
public class PageResult implements Serializable {

    private Long total;//总记录数
    private List rows;//当前页记录 不知到传入的是什么，不指定泛型


    /**
     * @param total 总页数
     * @param rows  每页条数
     */
    public PageResult(Long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    /**
     * @return total GET
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total SET
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * @return rows GET
     */
    public List getRows() {
        return rows;
    }

    /**
     * @param rows SET
     */
    public void setRows(List rows) {
        this.rows = rows;
    }
}
