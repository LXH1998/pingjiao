package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/11 12:28
 * @VERSION: 1.0
 **/


@Repository
public interface UserMapper {
    List<HashMap> selectAllUser(int pages,int limit);
    int updateUserPassword(int user_Id);
    int updateUserState(int user_Id);
    List<HashMap> selectAccountUsers(String user_Account,String role_name,int pages,int limit);
    List<HashMap> selectAccountUsersCount(String user_Account,String role_name);
    List<Role> selectAllRole();
    List<HashMap> selectCount();
    List<Departments> selectAllDepartments();
    List<HashMap> selectAllClass(int departments_Id);
    int updateUserInformation(String user_Name,String user_Account,String user_Sex,int departments_Id,int class_Id,int user_Id);
    int updateUserRole(int role_Id,int user_Id);
    int insertUserInformation(String user_Name,String user_Account,String user_Sex,int departments_Id,int class_Id);
    int insertUserRole(int role_Id,int user_Id);
    List<User> selectUserId(String user_Name,String user_Account);
}
