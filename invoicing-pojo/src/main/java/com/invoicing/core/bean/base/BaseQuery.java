package com.invoicing.core.bean.base;

import java.io.Serializable;

/**
 * 查询基类
 * 
 * @author yong.cao
 * @time 2017年7月30日 下午9:27:30
 */
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 265900375595315903L;
    /**
     * 页码数
     */
    private Integer           pageNo           = 1;
    /**
     * 每页条数（pageSize）
     */
    private Integer           limit            = 10;
    /**
     * 开始行
     */
    private Integer           start            = 0;
    /**
     */
    private Boolean           page             = false;

    /**
     * 总记录数
     */
    private Integer           results;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //重新计算start
        start = (pageNo - 1) * limit;
        //当pageNo为空、0时，设置为第一页
        this.pageNo = (null == pageNo || pageNo < 1) ? 1 : pageNo;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        //重新计算start
        start = (pageNo - 1) * limit;
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Boolean getPage() {
        return page;
    }

    public void setPage(Boolean page) {
        this.page = page;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

}
