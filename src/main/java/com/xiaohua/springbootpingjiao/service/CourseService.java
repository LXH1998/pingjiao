package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface CourseService {
    public List<Courses> SelectCourse(int pages,int limit);
    //查询所有课程数量
    int SelectCourseCount();
    public int deleteTheCourse(int id);
    public List<TeachData> SelectTeach(int pages,int limit);
    //查询授课信息数量
    int SelectTeachCount();
    //查询具体某一门课程是否存在
    public int SelectCourseOne(String courses_Name);
    //新增课程
    public int insertCourses(String courses_Name);
    //查找所有角色为教师的信息
    public List<User> SelectTeachUser();
    //修改授课信息
    public  int EditTeachs(int teach_id,String user_Id,String class_ID);
    //查询具体一门授课信息
    List<TeachData> SelectTeachOne(String courses_name,int pages,int limit);
    //查询具体一门授课信息数量
    int SelectTeachOneCount();
    //新增授课信息
    int  AddTeach(String courses_Id,String user_Id,String class_ID);

}
