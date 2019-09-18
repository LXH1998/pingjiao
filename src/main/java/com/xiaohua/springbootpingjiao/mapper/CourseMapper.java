package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface CourseMapper {
    //查询所有课程
    List<Courses> SelectCourseAll();
    //删除指定课程
    int deleteTheCourse(int id);
    //删除指定课程
//   List<Teach> SelectTeachAll();
   List<TeachData> SelectTeachAll();
}
