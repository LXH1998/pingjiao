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
//    查询一页数据
    @Override
    public List<Role> selectOnePageRoles(int thePage, int limit) {
        return roleMapper.selectOnePageRoles(thePage,limit);
    }

//    角色查询（模糊查询）
    @Override
    public List<Role> searchRole(String role_Name) {
        return roleMapper.searchRole(role_Name);
    }


    //    新增角色
    @Override
    public int selectTheRole(String role_Name) {
        return roleMapper.selectTheRole(role_Name);
    }
//    如果角色不存在，插入角色
    @Override
    public int insertRole(String role_Name) {
        return roleMapper.insertRole(role_Name);
    }
//    如果角色被隐式删除，恢复角色
    @Override
    public int changeStatus(String role_Name) {
        return roleMapper.changeStatus(role_Name);
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
//    每页显示10条权限
    @Override
    public List<Power> selectOnePagePower(int role_ID, int thePage, int limit) {
        return roleMapper.selectOnePagePower(role_ID,thePage,limit);
    }

    //    增加角色权限（1.1、查看未授权权限）
    @Override
    public List<Power> selectUnauthorizedPower(int role_ID) {
        return roleMapper.selectUnauthorizedPower(role_ID);
    }
//    增加角色权限（1.1、查看未授权权限--每页显示数据条数）
    @Override
    public List<Power> selectOnePageUnauthorizedPower(int role_ID, int thePage, int limit) {
        return roleMapper.selectOnePageUnauthorizedPower(role_ID,thePage,limit);
    }
//    增加角色权限（1.2、增加角色权限）
    @Override
    public int insertRolePower(int role_Id, int power_Id) {
        return roleMapper.insertRolePower(role_Id,power_Id);
    }

    //    删除角色权限
    @Override
    public int deleteThePower(int role_Id, int power_Id) {
        return roleMapper.deleteThePower(role_Id,power_Id);
    }


}