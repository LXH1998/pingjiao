package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface CourseMapper {
    //查询所以课程
    List<Courses> SelectCourseAll();
    int deleteTheCourse(int id);
}
