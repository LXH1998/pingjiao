package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.entity.User;
import com.xiaohua.springbootpingjiao.mapper.UserMapper;
import com.xiaohua.springbootpingjiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/11 12:30
 * @VERSION: 1.0
 **/

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<HashMap> selectAllUser(int pages,int limit){
        return userMapper.selectAllUser(pages,limit);
    }

    @Override
    public Boolean updateUserPassword(int user_Id) {
        int userResult = userMapper.updateUserPassword(user_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUserState(int user_Id) {
        int userResult = userMapper.updateUserState(user_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> selectAccountUsers(String user_Account, String role_name, int pages, int limit) {
        return userMapper.selectAccountUsers(user_Account,role_name,pages,limit);
    }

    @Override
    public List<HashMap> selectAccountUsersCount(String user_Account, String role_name) {
        return userMapper.selectAccountUsersCount(user_Account,role_name);
    }



    @Override
    public List<Role> selectAllRole() {
        return userMapper.selectAllRole();
    }

    @Override
    public List<HashMap> selectCount() {
        return userMapper.selectCount();
    }

    @Override
    public List<Departments> selectAllDepartments() {
        return userMapper.selectAllDepartments();
    }

    @Override
    public List<HashMap> selectAllClass(int departments_Id) {
        return userMapper.selectAllClass(departments_Id);
    }

    @Override
    public Boolean updateUserInformation(String user_Name, String user_Account, String user_Sex, int departments_Id, int class_Id, int user_Id) {
        int userResult = userMapper.updateUserInformation(user_Name,user_Account,user_Sex,departments_Id,class_Id,user_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUserRole(int role_Id, int user_Id) {
        int userResult = userMapper.updateUserRole(role_Id,user_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertUserInformation(String user_Name, String user_Account, String user_Sex, int departments_Id, int class_Id) {
        int userResult = userMapper.insertUserInformation(user_Name,user_Account,user_Sex,departments_Id,class_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertUserRole(int role_Id, int user_Id) {
        int userResult = userMapper.insertUserRole(role_Id,user_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<User> selectUserId(String user_Name, String user_Account) {
        return userMapper.selectUserId(user_Name,user_Account);
    }

    @Override
    public List<HashMap> selectUserHaveRole(int user_id) {
        return userMapper.selectUserHaveRole(user_id);
    }

    @Override
    public Boolean deleteUserIdRole(int user_Id) {
        int userResult = userMapper.deleteUserIdRole(user_Id);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertUserIdRole(int user_Id, int role_ID) {
        int userResult = userMapper.insertUserIdRole(user_Id,role_ID);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> selectUserIfRepeat(String user_account) {
        return userMapper.selectUserIfRepeat(user_account);
    }
}
