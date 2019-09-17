package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.mapper.CourseMapper;
import com.xiaohua.springbootpingjiao.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程实现类
 * @author langxiaohua
 * @version 1.0
 * @date 2019/9/16 0016 9:30
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;
//查找所有课程
    @Override
    public List<Courses> SelectCourse() {
        return courseMapper.SelectCourseAll();
    }

    //查找课程
    @Override
    public int deleteTheCourse(int id) {
        return courseMapper.deleteTheCourse(id);
    }
}
