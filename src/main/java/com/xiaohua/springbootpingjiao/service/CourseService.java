package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;

import java.util.List;

public interface CourseService {
    public List<Courses> SelectCourse();
    public int deleteTheCourse(int id);
    public List<TeachData> SelectTeach();
}
