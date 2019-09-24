package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.mapper.RoleMapper;
import com.xiaohua.springbootpingjiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//    角色查询（模糊查询-每页显示数据条数）
    @Override
    public List<Role> searchTheOnePageRole(String role_Name, int thePage, int limit) {
        return roleMapper.searchTheOnePageRole(role_Name,thePage,limit);
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

    //    查看角色拥有权限
    @Override
    public List<Power> selectThePower(int role_ID) {
        return roleMapper.selectThePower(role_ID);
    }

//    树
//    @Override
//    public List<Map<String, Object>> getTreeList(Integer id,int role_ID) {
//        List<Power> list = roleMapper.getTreeList(role_ID);
//        return buildTree(id, list);
//    }
//      public List<Map<String, Object>> buildTree(Integer pid, List<Power> list){
//            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//            // 1.边界条件
//            List<Power> childList = list.stream().filter(item -> item.getPower_parentid().intValue()==pid).collect(Collectors.toList());
//            // 3.返回段
//            if(childList.isEmpty()){ return result;}
//
//            // 2.前进段
//            childList.stream().forEach(item->{
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", item.getPower_Id());
//                map.put("title", item.getPower_Name());
//                map.put("pid", item.getPower_parentid());
//                map.put("href", item.getPower_url());
//                map.put("status", item.getPower_state());
//
//                List<Map<String, Object>> childs = buildTree(item.getPower_Id(), list);
//                if(!childs.isEmpty()){
//                    map.put("children", childs);
//                }
//                result.add(map);
//            });
//            return result;
//        }


//    查询所有权限
    @Override
    public List<Power> selectAllPower() {
        return roleMapper.selectAllPower();
    }


//    增加角色权限（插入角色在中间表中不存在的权限）
    @Override
    public int insertRolePower(int role_Id, int power_Id) {
        return roleMapper.insertRolePower(role_Id,power_Id);
    }
//    增加角色权限（修改角色在中间表存在但状态值为0的权限，修改状态值为1）
    @Override
    public int updateTheDeletePowerTest(int role_Id,int power_Id) {
        return roleMapper.updateTheDeletePowerTest(role_Id,power_Id);
    }

    //    删除角色权限（将角色拥有的权限状态值改为0）
    @Override
    public int deleteThePowerTest(int role_Id) {
        return roleMapper.deleteThePowerTest(role_Id);
    }

    //    查询角色被删除的权限（角色拥有的权限，但状态值为0）
    @Override
    public List<Power> selectTheDeletePower(int role_Id) {
        return roleMapper.selectTheDeletePower(role_Id);
    }


}