package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;
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

    @Override
    public List<TeachData> SelectTeach() {
        return courseMapper.SelectTeachAll();
    }

    @Override
    public int SelectCourseOne(String courses_Name) {
        return courseMapper.SelectCourseOne(courses_Name);
    }

    @Override
    public int insertCourses(String courses_Name) {
        return courseMapper.insertCourses(courses_Name);
    }

    @Override
    public List<User> SelectTeachUser() {
        return courseMapper.SelectTeachUser();
    }
}
