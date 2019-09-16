package com.xiaohua.springbootpingjiao.entity;

/**
 * @ClassName: Paging
 * @author:xiaoyi
 * @date: 2019/9/12 17:57
 * @Description : 分页实体
 */
public class Paging {
    /**当前页码*/
    private Integer pages;
    /**每页显示条数*/
    private Integer limits;

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = (pages-1)*limits;
    }

    public Integer getLimits() {
        return limits;
    }

    public void setLimits(Integer limits) {
        this.limits = limits;
    }
}
