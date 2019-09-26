package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.Teach;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;
import com.xiaohua.springbootpingjiao.service.ClassService;
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
    @Autowired
    public ClassService classService;

    //查询课程
    @RequestMapping("/listDate")
    @ResponseBody
    public Map CourseListAll(int page,int limit){
        int pages = (page-1)*limit;
        List<Courses> courseList = courseService.SelectCourse(pages,limit);
        int count = courseService.SelectCourseCount();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",count);
        result.put("data",courseList);
        return result;
    }
    //查询所以课程
    @RequestMapping("/listDateAll")
    @ResponseBody
    public Map CourseListAll(){
        List<Courses> courseList = courseService.SelectCourse(0,1000);
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",courseList);
        return result;
    }

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
    //跳转到课程列表页面
    @RequestMapping("/list")
    public String CourseList(){
        return "admin/course/course_list";
    }
    //跳转到授课页面
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
    public Map TeachListAll(int page,int limit){
        int pages = (page-1)*limit;
        List<TeachData> teachList = courseService.SelectTeach(pages,limit);
        int count = courseService.SelectTeachCount();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",teachList);
        result.put("count",count);
        return result;
    }

    //查询具体一门所有授课信息
    @ResponseBody
    @RequestMapping("/oneTeachListData")
    public Map OneTeachListDate(String courses_name,int page,int limit){
        int pages = (page-1)*limit;
        List<TeachData> teachList = courseService.SelectTeachOne(courses_name,pages,limit);
        int count = courseService.SelectTeachOneCount();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",teachList);
        result.put("count",count);
        return result;
    }
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
    //查询课程信息
    @ResponseBody
    @RequestMapping("/classInfo")
    public HashMap ClassData(){
        HashMap result = new HashMap();
        List<Class> classes = classService.selectAllClassCount();
        result.put("code",0);
        result.put("msg","");
        result.put("data",classes);
        return result;
    }
    //跳转到授课修改界面
    @RequestMapping("/editTeach")
    public String editTeach(){
        return "admin/course/course_EditTeach";
    }
    //跳转到增加授课界面
    @RequestMapping("/addTeach")
    public String addTeach(){
        return "admin/course/course_AddTeach";
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
    /**
     * 修改授课信息
     * */
    @ResponseBody
    @RequestMapping("/editTheTeach")
    public Map editTeach(int teach_id, String user_Id, String class_ID){
        int EditResult = courseService.EditTeachs(teach_id,user_Id,class_ID);
        Map result = new HashMap();
        if (EditResult == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }
    /**
     * 新增授课信息
     * */
    @ResponseBody
    @RequestMapping("/addTeachInfo")
    public Map addTeach(String courses_Id, String user_Id, String class_ID){
        int EditResult = courseService.AddTeach(courses_Id,user_Id,class_ID);
        Map result = new HashMap();
        if (EditResult == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }
}
