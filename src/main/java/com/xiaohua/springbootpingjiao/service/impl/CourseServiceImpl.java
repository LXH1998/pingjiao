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
    public List<Courses> SelectCourse(int pages,int limit) {
        return courseMapper.SelectCourseAll(pages,limit);
    }

    @Override
    public int SelectCourseCount() {
        return courseMapper.SelectCourseCount();
    }

    //查找课程
    @Override
    public int deleteTheCourse(int id) {
        return courseMapper.deleteTheCourse(id);
    }

    @Override
    public List<TeachData> SelectTeach(int pages,int limit) {
        return courseMapper.SelectTeachAll(pages,limit);
    }
    //查询授课信息数量
    @Override
    public int SelectTeachCount() {
        return courseMapper.SelectTeachCount();
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

    @Override
    public int EditTeachs(int teach_id, String user_Id, String class_ID) {
        return courseMapper.EditTeach(teach_id,user_Id,class_ID);
    }

    //查询具体一门授课信息
    @Override
    public List<TeachData> SelectTeachOne(String courses_name, int pages, int limit) {
        return courseMapper.SelectTeachOne(courses_name,pages,limit);
    }

    @Override
    public int SelectTeachOneCount() {
        return courseMapper.SelectTeachOneCount();
    }

    //新增授课信息
    @Override
    public int AddTeach(String courses_Id, String user_Id, String class_ID) {
        return courseMapper.AddTeach(courses_Id,user_Id,class_ID);
    }
    //查询具体一门课程授课信息
    @Override
    public List<TeachData> SelectTeachCourseOne(String courses_id, int pages, int limit) {
        return courseMapper.SelectTeachCourseOne(courses_id,pages,limit);
    }
//    查询具体一门课程授课信息数量
    @Override
    public int SelectTeachCourseOneCount(String courses_id) {
        return courseMapper.SelectTeachCourseOneCount(courses_id);
    }
    //    根据班级查询具体一门课程授课信息
    @Override
    public List<TeachData> SelectTeachCourseOneInClass(String class_name, String courses_id, int pages, int limit) {
        return courseMapper.SelectTeachCourseOneInClass(class_name,courses_id,pages,limit);
    }
    //    根据班级查询具体一门课程授课信息数量
    @Override
    public int SelectTeachCourseOneCount(String class_name, String courses_id) {
        return courseMapper.SelectTeachCourseOneCount(class_name,courses_id);
    }

}
