package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;

import java.util.List;

public interface RoleService {
//    查询所有角色
    public List<Role> selectAllRoles();

//    新增角色
    public int selectTheRole(String role_Name);
    public int insertRole(String role_Name);

//    删除角色
    public int deleteTheRole(String role_Name);

//    查看权限
    public List<Power> selectThePower(int role_ID);

//    增加角色权限（1.1、查看未授权权限）
    public List<Power> selectUnauthorizedPower(int role_ID);


}
