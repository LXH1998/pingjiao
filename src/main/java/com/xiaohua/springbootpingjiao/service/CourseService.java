package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface CourseService {
    public List<Courses> SelectCourse();
    public int deleteTheCourse(int id);
    public List<TeachData> SelectTeach();
    //查询具体某一门课程是否存在
    int SelectCourseOne(String courses_Name);
    //新增课程
    public int insertCourses(String courses_Name);
    //查找所有角色为教师的信息
    List<User> SelectTeachUser();
}
