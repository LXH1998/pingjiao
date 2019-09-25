package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
//    查询所有角色
    public List<Role> selectAllRoles();
//    查询一页数据
    public List<Role> selectOnePageRoles(int thePage, int limit);

//    角色查询（模糊查询）
    public List<Role> searchRole(String role_Name);
//    角色查询（模糊查询-每页显示数据条数）
    public List<Role> searchTheOnePageRole(String role_Name,int thePage,int limit);

//    新增角色
    public int selectTheRole(String role_Name);
    public int insertRole(String role_Name);
    public int changeStatus(String role_Name);

//    删除角色
    public int deleteTheRole(String role_Name);

//    查看角色拥有的权限
    public List<Power> selectThePower(int role_ID);


//    树
//    List<Map<String, Object>> getTreeList(Integer id,int role_ID);

//    查询所有权限
    List<Power> selectAllPower();

//    增加角色权限（插入角色在中间表中不存在的权限）
    public int insertRolePower(int role_Id, int power_Id);
//    增加角色权限（修改角色在中间表存在但状态值为0的权限，修改状态值为1）
    public int updateTheDeletePowerTest(int role_Id,int power_Id);


//    删除角色权限（将角色拥有的权限状态值改为0）
    public int deleteThePowerTest(int role_Id);

//    查询角色被删除的权限（角色拥有的权限，但状态值为0）
    public List<Power> selectTheDeletePower(int role_Id);


}
