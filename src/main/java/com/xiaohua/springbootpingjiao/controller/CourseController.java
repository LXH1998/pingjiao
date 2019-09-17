package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.service.CourseService;
import com.xiaohua.springbootpingjiao.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    //查询课程
    @RequestMapping("/listDate")
    @ResponseBody
    public Map CourseListAll(){
        List<Courses> CourseList = courseService.SelectCourse();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",CourseList.size());
        result.put("data",CourseList);
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

}
