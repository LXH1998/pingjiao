package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public interface ClassMapper {
    List<HashMap> selectAllClass(int pages,int limit);
    List<Class> selectAllClassCount();

    List<Departments> queryAllDepartments();
    List<Departments> selectDepartId(String departments_Name);
    int insertClass(Class c);
//院系id重载
    List<HashMap> selectClassWhereDepartId(String departments_id,int pages,int limit);
    List<HashMap> selectClassWhereDepartIdCount(String departments_id);
//班级编号重载
    List<HashMap> selectClassWhereClassId(String class_Id);
    List<HashMap> selectClassWhereClassIdlist(String class_Id,int pages,int limit);
    //指定院系的班级编号重载
    List<HashMap> selectClassWhereCdId(String class_Id,String departments_id);
    List<HashMap> selectClassWhereCdIdlist(String class_Id,String departments_id,int pages,int limit);

    int deleteClass(Class c);

}
