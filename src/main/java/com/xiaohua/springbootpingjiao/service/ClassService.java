package com.xiaohua.springbootpingjiao.service;


import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClassService {
    List<HashMap> selectAllClass(int pages,int limit);
    List<Class> selectAllClassCount();
    List<Departments> queryAllDepartments();
    List<Departments> selectDepartId(String departments_Name);
    boolean insertClass(Class c);

    List<HashMap> selectClassWhereDepartId(String departments_id,int pages,int limit);
    List<HashMap> selectClassWhereDepartIdCount(String departments_id);

    List<HashMap> selectClassWhereClassIdlist(String class_Id,int pages,int limit);
    List<HashMap> selectClassWhereClassId(String class_Id);

    List<HashMap> selectClassWhereCdId(String class_Id,String departments_id);
    List<HashMap> selectClassWhereCdIdlist(String class_Id,String departments_id,int pages,int limit);

    List<HashMap>  selectUserinClass(String class_Id);


    boolean deleteClass(Class c);
}
