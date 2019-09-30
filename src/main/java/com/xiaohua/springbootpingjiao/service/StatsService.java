package com.xiaohua.springbootpingjiao.service;

public interface StatsService {
    /**
     * 查询所有院系数量
     */
    int   queryDepartmentSize();
    /**
     * 查询所有在职老师数量
     */
    int   querTeacherSize();
}
