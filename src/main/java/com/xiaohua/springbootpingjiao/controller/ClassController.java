package com.xiaohua.springbootpingjiao.controller;

import com.sun.javafx.collections.MappingChange;
import com.xiaohua.springbootpingjiao.entity.Class;
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


    @ResponseBody
    @RequestMapping("/goclass")
    public HashMap ClassData(){
        HashMap result = new HashMap();
        List<HashMap> classes = classService.selectAllClass();
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
}
