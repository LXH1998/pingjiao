package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Departments;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatsMapper
 * @author:xiaoyi
 * @date: 2019/9/29 10:12
 * @Description :
 */
@Repository
public interface StatsMapper {
    /**
     * 查询所有院系数量
     */
    List<Map>  queryDepartmentSize();

    /**
     * 查询所有在职老师数量
     *
     */
    List<Map>  querTeacherSize();

    List<Map>  qeryDepartmentCount();
}
