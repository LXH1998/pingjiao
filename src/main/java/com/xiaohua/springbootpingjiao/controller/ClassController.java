package com.xiaohua.springbootpingjiao.controller;

import com.sun.javafx.collections.MappingChange;
import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.service.ClassService;
import com.xiaohua.springbootpingjiao.service.impl.ClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    public ClassService classService;



    @RequestMapping("/queryDepartments")
    @ResponseBody
    public HashMap queryDepartments(){
        HashMap result = new HashMap();
        List<Departments> classes = classService.queryAllDepartments();
        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
        result.put("data",classes);
        return result;
    }

    @ResponseBody
    @RequestMapping("/goclass")
    public HashMap ClassData(int page,int limit){
        int pages = (page-1)*limit;
        HashMap result = new HashMap();
        List<HashMap> classes = classService.selectAllClass(pages,limit);
        List<Class> classList = classService.selectAllClassCount();
        result.put("code",0);
        result.put("msg","");
        result.put("count",classList.size());
        result.put("data",classes);
        return result;
    }

    @ResponseBody
    @RequestMapping("/departments_id")
    public  HashMap selectDepartId(String departments_Name){
        HashMap result = new HashMap();
        List<Departments> departments = classService.selectDepartId(departments_Name);
        result.put("data",departments);
        return  result;
    }
    @ResponseBody
    @RequestMapping("/classindepartments")
    public  HashMap selectClassWhereDepartments(String departments_id){
        HashMap result = new HashMap();
        List<HashMap> classes = classService.selectClassWhereDepartId(departments_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
        result.put("data",classes);
        return result;
    }

    @ResponseBody
    @RequestMapping("/classinclassid")
    public  HashMap selectClassWhereClassid(String class_Id){
        HashMap result = new HashMap();
        List<HashMap> classes = classService.selectClassWhereClassId(class_Id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
        result.put("data",classes);
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteClass")
    public  boolean deleteClass(String class_Id){
        Class c = new Class();
        c.setClass_Id(Integer.parseInt(class_Id));
        boolean flag = classService.deleteClass(c);
        if (flag){
            return   true;
        }
        return  false;

    }


    @ResponseBody
    @RequestMapping("/insertClass")
    public  boolean insertClass(String class_Id,String  class_Name,String departments_id){
        Class c = new Class();
        c.setClass_Id(Integer.parseInt(class_Id));
        c.setClass_Name(class_Name);
        c.setDepartments_id(Integer.parseInt(departments_id));
        boolean flag = classService.insertClass(c);
        if (flag){
            return   true;
        }
        return  false;

    }
    /***
     * 指定院系班级编号重载
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping("/classincd")
    public  HashMap selectClassWhereCdId(String class_Id,String departments_id){
        HashMap result = new HashMap();
        List<HashMap> classes = classService.selectClassWhereCdId(class_Id,departments_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
        result.put("data",classes);
        return result;
    }


    @RequestMapping("goaddclass")
    public String goclass(){
        return "admin/class/addclass";
    }
    @RequestMapping("goaddstudent")
    public String addStudent(){
        return "admin/class/addStudent";
    }
    @RequestMapping("goindex")
    public String goindex(){
        return "index";
    }
    @RequestMapping("gclass")
    public String gclass(){
        return "admin/class/class";
    }
}
