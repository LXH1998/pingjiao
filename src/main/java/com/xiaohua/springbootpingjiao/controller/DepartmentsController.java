package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;
    @RequestMapping("IndexAdmin")     //进入院系管理
    public String IndexAdmin(){
        return "admin/department/departments1";
    }

    @RequestMapping("class")     //进入院系详情
    public String indexclass(){
        return "admin/class/class";
    }

    @ResponseBody
    @RequestMapping("AdminClass")
    public Map selectDepartment(){          //查询所有院系
        List<Departments> classes = departmentsService.Departments();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",classes);
        result.put("count",classes.size());
        return result;
    }

    @ResponseBody
    @RequestMapping("selectClass1")          //查询院系对应的班级基本信息
    public Map selectClass1(int depart){
        List<HashMap> classes = departmentsService.selectClass1(depart);
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",classes);
        result.put("count",classes.size());
        return result;
    }

    @ResponseBody
    @RequestMapping("delete")                //删除院系
    public List<Departments> delete(int departments_id){
        List<Departments> classes = departmentsService.deleteDepartments(departments_id);
        return classes;
    }

    @ResponseBody
    @RequestMapping("insert")                //增加院系
    public String insert(int aa, String bb){
        String  departments1 = departmentsService.selectDepartments1(aa);
        String departments2 = departmentsService.selectDepartments2(bb);
        if(departments1 != null){                       //判断是否存在ID为aa的数据，若存在，则该ID已被占用
            return departments1;
        }else if(departments2 != null){                   //判断是否存在学院名称为bb的数据，若存在，则该名称已被占用
            return departments2 + 1;
        }
        String classes = departmentsService.insertDepartments(aa,bb);           //ID与学院名称均未被占用时，增加学院
        return classes;
    }

}
