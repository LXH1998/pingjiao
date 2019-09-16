package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.mapper.RoleMapper;
import com.xiaohua.springbootpingjiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

//    查询所有角色
    @Override
    public List<Role> selectAllRoles() {
        return roleMapper.selectAllRoles();
    }


    //    新增角色
    @Override
    public int selectTheRole(String role_Name) {
        return roleMapper.selectTheRole(role_Name);
    }

    @Override
    public int insertRole(String role_Name) {
        return roleMapper.insertRole(role_Name);
    }

//    删除角色
    @Override
    public int deleteTheRole(String role_Name) {
        return roleMapper.deleteTheRole(role_Name);
    }

//    查看权限
    @Override
    public List<Power> selectThePower(int role_ID) {
        return roleMapper.selectThePower(role_ID);
    }

//    增加角色权限（1.1、查看未授权权限）
    @Override
    public List<Power> selectUnauthorizedPower(int role_ID) {
        return roleMapper.selectUnauthorizedPower(role_ID);
    }


}
