package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;
import com.xiaohua.springbootpingjiao.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 课程信息处理层
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    //查询课程
    @RequestMapping("/listDate")
    @ResponseBody
    public Map CourseListAll(){
        List<Courses> courseList = courseService.SelectCourse();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",courseList.size());
        result.put("data",courseList);
        return result;
    }
//    @ResponseBody
//    @RequestMapping("/listDate")
//    public String GetUser(){
//        return courseService.SelectCourse().toString();
//    }
    /**
     * 点击删除，删除指定课程
     * */
    @ResponseBody
    @RequestMapping("/deleteOne")
    public Map deleteTheRole(int courses_Id){
        int deleteResult = courseService.deleteTheCourse(courses_Id);
        Map result = new HashMap();
        if (deleteResult == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }
    @RequestMapping("/list")
    public String CourseList(){
        return "admin/course/course_list";
    }
    @RequestMapping("/teach")
    public String Courseteach(){
        return "admin/course/course_teach";
    }
    @RequestMapping("/test")
    public String test(){
        return "admin/course/list";
    }
    //查询所有授课信息
    @ResponseBody
    @RequestMapping("/teachListDate")
    public Map TeachListAll(){
        List<TeachData> teachList = courseService.SelectTeach();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",teachList);
        result.put("count",teachList.size());
        return result;
    }
    //判断课程是否存在
//    @ResponseBody
//    @RequestMapping("/insertRole")
//    public Map insertRole(String courses_Name){
//        int coursesIf = courseService.SelectCourseOne(courses_Name);
//        Map result = new HashMap();
//        if(coursesIf == 0)
//        {
//            result.put("result","T");
//        }else
//        {
//            result.put("result","F");
//        }
//        return result;
//    }
    //增加课程
    @ResponseBody
    @RequestMapping("/insertCourse")
    public Map insertCourse(String course_Name){
        int coursesIf = courseService.SelectCourseOne(course_Name);
        Map result = new HashMap();
        if (coursesIf==0){
            int insertResult = courseService.insertCourses(course_Name);
            if (insertResult == 1){
                result.put("result","操作成功");
            }else {
                result.put("result","操作失败");
            }
        }else{
            result.put("result","角色已存在");
        }
        return result;
    }
    //跳转到授课修改界面
    @RequestMapping("/editTeach")
    public String editTeach(){
        return "admin/course/course_EditTeach";
    }
    /**
     * 查找所有角色为教师的信息
     * */
    @ResponseBody
    @RequestMapping("/teachUser")
    public Map selectTeachUser(){
        List<User> teachUsers = courseService.SelectTeachUser();
        Map result = new HashMap();
        if (teachUsers.size()==0){
            result.put("data","NULL");
        }else {
            result.put("data",teachUsers);
        }
        return result;
    }
}
