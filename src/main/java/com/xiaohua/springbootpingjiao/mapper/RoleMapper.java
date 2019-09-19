package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {

//    查询角色
    public List<Role> selectAllRoles();
//    查询一页的数据
    public List<Role> selectOnePageRoles(int thePage, int limit);

//    角色查询（模糊查询）
    public List<Role> searchRole(String role_Name);
//    角色查询（模糊查询-显示每页数据条数）
    public List<Role> searchTheOnePageRole(String role_Name,int thePage,int limit);

//    新增角色
    public int selectTheRole(String role_Name);
    public int insertRole(String role_Name);
    public int changeStatus(String role_Name);

//    删除角色
    public int deleteTheRole(String role_Name);

//    查看权限
    public List<Power> selectThePower(int role_ID);
//    查看一页的权限
    public List<Power> selectOnePagePower(int role_ID, int thePage, int limit);

//    增加角色权限(1.1、查看未授权权限)
    public List<Power> selectUnauthorizedPower(int role_ID);
//    增加角色权限(1.1、查看未授权权限,每页显示几条数据)
    public List<Power> selectOnePageUnauthorizedPower(int role_ID, int thePage, int limit);
//    增加角色权限
    public int insertRolePower(int role_Id, int power_Id);

//    删除角色权限
    public int deleteThePower(int role_Id, int power_Id);
}
