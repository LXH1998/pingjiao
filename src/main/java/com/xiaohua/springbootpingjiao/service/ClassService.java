package com.xiaohua.springbootpingjiao.service;


import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClassService {
    List<HashMap> selectAllClass();
    List<Departments> queryAllDepartments();
    List<Departments> selectDepartId(String departments_Name);
    boolean insertClass(Class c);
}
