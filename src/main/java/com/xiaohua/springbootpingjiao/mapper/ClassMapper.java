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
//指定班级查找学生
List<HashMap>  selectUserinClass(String class_Id);

//删除班级
    int deleteClass(Class c);

    //判断班级是否纯在
    List<HashMap>classHave(String class_Id);

    //根据班级ID修改班级名称
    int updateClassIdNname(String class_Name,int class_Id);

}
