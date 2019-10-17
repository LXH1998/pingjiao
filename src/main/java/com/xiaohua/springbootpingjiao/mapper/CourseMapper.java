package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseMapper {
    //查询所有课程
    List<Courses> SelectCourseAll(int pages,int limit);
    //查询所有课程数量
    int SelectCourseCount();

    //查询具体某一门课程是否存在
    int SelectCourseOne(String courses_Name);

    //删除指定课程
    int deleteTheCourse(int id);
    //查找所有角色为教师的信息
    List<User> SelectTeachUser();
    //新增课程
    int insertCourses(String courses_Name);
    //查询所有授课信息
    List<TeachData> SelectTeachAll(int pages,int limit);
    //查询具体一门课程授课信息
    List<TeachData> SelectTeachCourseOne(String courses_id,int pages,int limit);
//    <!--查询具体一门课程授课信息数量-->
    int SelectTeachCourseOneCount(String courses_id);
//    根据班级查询具体一门课程授课信息
    List<TeachData> SelectTeachCourseOneInClass(String class_name,String courses_id,int pages,int limit);
//    根据班级查询具体一门课程授课信息数量
    int SelectTeachCourseOneCount(String class_name,String courses_id);
    //查询授课信息数量
    int SelectTeachCount();
    //查询具体一门授课信息
    List<TeachData> SelectTeachOne(String courses_name,int pages,int limit);
    //查询具体一门授课信息数量
    int SelectTeachOneCount();
    //修改授课信息
    int EditTeach(int teach_id,String user_Id,String class_ID);
    //新增授课信息
    int  AddTeach(String courses_Id,String user_Id,String class_ID);

}
