package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface CourseMapper {
    //查询所有课程
    List<Courses> SelectCourseAll();
    //查询具体某一门课程是否存在
    int SelectCourseOne(String courses_Name);
    //删除指定课程
    int deleteTheCourse(int id);
    //查找所有角色为教师的信息
    List<User> SelectTeachUser();
    //新增课程
    int insertCourses(String courses_Name);
    //查询授课信
   List<TeachData> SelectTeachAll();

}
