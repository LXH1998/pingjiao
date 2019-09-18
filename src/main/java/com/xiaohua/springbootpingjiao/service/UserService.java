package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Role;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/11 12:29
 * @VERSION: 1.0
 **/

public interface UserService {
    List<HashMap> selectAllUser(int pages,int limit);
    Boolean updateUserPassword(int user_Id);
    Boolean updateUserState(int user_Id);
    List<HashMap> selectAccountUsers(String user_Account,String role_name);
    List<Role> selectAllRole();
    List<HashMap> selectCount();
    List<Departments> selectAllDepartments();
    List<HashMap> selectAllClass(int departments_Id);
}
