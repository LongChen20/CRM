package com.crm.domain;

import java.util.List;

/**
 * @author LGCN
 * 封装分页查询条件。
 */
public class pageBean<T> {
    /**
     * 当前页
     */
    private Integer currPage;
    /**
     * 每一页显示多少条
     */
    private Integer pageSize;
    /**
     * 总记录
     */
    private Integer totalCount;
    /**
     * 总条数
     */
    private Integer totalPage;
    /**
     * 数据集合
     */
    private List<T> rowPage;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRowPage() {
        return rowPage;
    }

    public void setRowPage(List<T> rowPage) {
        this.rowPage = rowPage;
    }
}
