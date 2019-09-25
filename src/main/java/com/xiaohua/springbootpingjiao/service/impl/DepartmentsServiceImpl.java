package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.mapper.DepartmentsMapper;
import com.xiaohua.springbootpingjiao.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsMapper departmentsMapper;

    @Override
    public List<Departments> Departments() {                //查询所有院系
        return departmentsMapper.Departments();
    }

    @Override
    public List<HashMap> selectClass1(int depart){             //查询院系所有班级
        return departmentsMapper.selectClass1(depart);
    }

    @Override
    public List<Departments> deleteDepartments(int departments_id){          //删除院系
        return departmentsMapper.deleteDepartments(departments_id);
    }

    @Override
    public String insertDepartments(int departments_id,String departments_name){      //增加院系
        return departmentsMapper.insertDepartments(departments_id,departments_name);
    }

    @Override
    public String selectDepartments1(int departments_id){          //增加院系时判断是否存在已有id
        return departmentsMapper.selectDepartments1(departments_id);
    }

    @Override
    public String selectDepartments2(String departments_name){     //增加院系时判断是否存在已有学院
        return departmentsMapper.selectDepartments2(departments_name);
    }

}
