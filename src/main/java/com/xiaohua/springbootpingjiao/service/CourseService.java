package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Courses;

import java.util.List;

public interface CourseService {
    public List<Courses> SelectCourse();
    public int deleteTheCourse(int id);
}
