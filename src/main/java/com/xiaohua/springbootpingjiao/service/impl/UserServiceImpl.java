package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Role;
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
    public List<HashMap> selectAccountUsers(String user_Account,String role_name) {
        return userMapper.selectAccountUsers(user_Account,role_name);
    }

    @Override
    public List<Role> selectAllRole() {
        return userMapper.selectAllRole();
    }

    @Override
    public List<HashMap> selectCount() {
        return userMapper.selectCount();
    }
}
