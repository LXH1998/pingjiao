package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Departments;

import java.util.HashMap;
import java.util.List;

public interface DepartmentsMapper {
      List<Departments> Departments();    //查询院系
      List<HashMap> selectClass1(int depart);    //查询院系详情
      List<Departments> deleteDepartments(int departments_id);    //删除院系
      String insertDepartments(int departments_id, String departments_name);   //添加院系
      String selectDepartments1(int departments_id);      //添加院系时是否存在相同id
      String selectDepartments2(String departments_name);   //添加院系时是否存在相同学院
}
