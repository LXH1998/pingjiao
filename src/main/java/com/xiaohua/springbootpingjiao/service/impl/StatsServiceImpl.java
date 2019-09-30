package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.mapper.StatsMapper;
import com.xiaohua.springbootpingjiao.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatsServiceImpl
 * @author:xiaoyi
 * @date: 2019/9/29 10:13
 * @Description :
 */
@Service
public class StatsServiceImpl  implements StatsService {
    @Autowired
    private StatsMapper statsMapper;

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/29 10:14
     * @param
     * @Description 查询所有院系数量
     */
    @Override
    public int queryDepartmentSize() {
        List<Map> list = statsMapper.queryDepartmentSize();
        if (!list.isEmpty()){
            Object count = list.get(0).get("departmentSize");
            int size = Integer.parseInt(count.toString());
            return size;
        }
        return 0;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/29 10:39
    * @param
    * @Description 查询所有在职老师数量
    */
    @Override
    public int querTeacherSize() {
        List<Map> list = statsMapper.querTeacherSize();
        if (!list.isEmpty()){
            Object count = list.get(0).get("userSize");
            int size = Integer.parseInt(count.toString());
            return size;
        }
        return 0;
    }


}
