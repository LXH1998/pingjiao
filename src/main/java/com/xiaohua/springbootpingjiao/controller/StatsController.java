package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: StatisticalController
 * @author:xiaoyi
 * @date: 2019/9/28 15:16
 * @Description : 统计分析Controller
 */
@Controller
@RequestMapping("stats")
public class StatsController {
    @Autowired
    private StatsService service;
    @RequestMapping("goIndex")
    public String goStatsIndex(){
        return "/admin/stats/stats_index";
    }


    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/29 10:44
    * @param
    * @Description 统计顶部信息
    */
    @ResponseBody
    @RequestMapping("queryTopMsg")
    public Map queryTopMsg(){
        Map map = new HashMap();
        map.put("departmentSize",service.queryDepartmentSize());
        map.put("teacherSize",service.querTeacherSize());
        return map;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/29 10:19
    * @param
    * @Description 查询所有院系数量
    */
    @RequestMapping("queryDepartmentSize")
    @ResponseBody
    public Map queryDepartmentSize(){
        int size = service.queryDepartmentSize();
        Map map = new HashMap();
        map.put("departmentSize",size);
        return map;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/29 10:41
    * @param
    * @Description 查询所有在职老师数量
    */
    @RequestMapping("querTeacherSize")
    @ResponseBody
    public Map querTeacherSize(){
        int size = service.querTeacherSize();
        Map map = new HashMap();
        map.put("userSize",size);
        return map;
    }

}
