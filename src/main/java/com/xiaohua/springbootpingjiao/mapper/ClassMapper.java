package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public interface ClassMapper {
    List<HashMap> selectAllClass();
    List<Departments> queryAllDepartments();
    List<Departments> selectDepartId(String departments_Name);
    int insertClass(Class c);
    List<HashMap> selectClassWhereDepartId(String departments_id);
    List<HashMap> selectClassWhereClassId(String class_Id);
    int deleteClass(Class c);

}
