package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.mapper.ClassMapper;
import com.xiaohua.springbootpingjiao.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    public ClassMapper classMapper;

    @Override
    public List<HashMap> selectAllClass(int pages, int limit) {
        return classMapper.selectAllClass(pages,limit);
    }

    @Override
    public List<Class> selectAllClassCount() {
        return classMapper.selectAllClassCount();
    }

    /***
     *  查询所有院系
     * @return
     */

    @Override
    public List<Departments> queryAllDepartments() {
        return classMapper.queryAllDepartments();
    }

    @Override
    public List<Departments> selectDepartId(String departments_Name) {
        return classMapper.selectDepartId(departments_Name);
    }




    /***
     * 插入班级
     * @param c
     * @return
     */
    @Override
    public boolean insertClass(Class c) {
        int result = classMapper.insertClass(c);
        if (result > 0) {
            return true;
        }
        return false;
    }
    /***
     * 指定院系班级编号重载
     * @param
     * @return
     */
    @Override
    public List<HashMap> selectClassWhereCdId(String class_Id, String departments_id) {
        return classMapper.selectClassWhereCdId(class_Id,departments_id);
    }

    @Override
    public boolean deleteClass(Class c) {
        int result = classMapper.deleteClass(c);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> selectClassWhereClassId(String class_Id) {
        return classMapper.selectClassWhereClassId(class_Id);
    }

    @Override
    public List<HashMap> selectClassWhereDepartId(String departments_id) {
        return classMapper.selectClassWhereDepartId(departments_id);
    }
}
