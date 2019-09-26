package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Class;

import java.util.HashMap;
import java.util.List;

public interface DepartmentsService {
    List<Departments> Departments();
    List<HashMap> selectClass1(int depart);
    List<Departments> deleteDepartments(int departments_id);
    String insertDepartments(int departments_id, String departments_name);
    String selectDepartments1(int departments_id);
    String selectDepartments2(String departments_name);
}
