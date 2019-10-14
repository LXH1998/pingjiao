package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.entity.User;

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
    List<HashMap> selectAccountUsers(String user_Account,String role_name,int pages,int limit);
    List<HashMap> selectAccountUsersCount(String user_Account,String role_name);
    List<Role> selectAllRole();
    List<HashMap> selectCount();
    List<Departments> selectAllDepartments();
    List<HashMap> selectAllClass(int departments_Id);
    Boolean updateUserInformation(String user_Name,String user_Account,String user_Sex,int departments_Id,int class_Id,int user_Id);
    Boolean updateUserRole(int role_Id,int user_Id);
    Boolean insertUserInformation(String user_Name,String user_Account,String user_Sex,int departments_Id,int class_Id);
    Boolean insertUserRole(int role_Id,int user_Id);
    List<User> selectUserId(String user_Name, String user_Account);
    List<HashMap> selectUserHaveRole(int user_id);
    Boolean deleteUserIdRole(int user_Id);
    Boolean insertUserIdRole(int user_Id,int role_ID);
    List<HashMap> selectUserIfRepeat(String user_account);

}
