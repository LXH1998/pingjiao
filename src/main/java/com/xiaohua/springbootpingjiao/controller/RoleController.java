package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roleManagement")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /***
     * 显示角色管理选项卡
     *
     */
    @RequestMapping("/goRole")
    public String goAdminIndex1(){
        return "admin/role/role_index";
    }

    /**
     * 权限弹窗
     */
    @RequestMapping("/checkPower")
    public String checkPower(){
        return "admin/role/role_power";
    }



    /**
     * 管理员点击角色管理，首先查询角色表所有角色，将数据返回页面
     * */
    @ResponseBody
    @RequestMapping("/allRoles")
    public Map selectAllRoles(){
        Map result = new HashMap();
        List<Role> roles = roleService.selectAllRoles();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",roles.size());
        result.put("data",roles);
        return result;
    }

    /**
     * 增加角色
     * */
    @ResponseBody
    @RequestMapping("/insertRole")
    public Map insertRole(String role_Name){
        int amount = roleService.selectTheRole(role_Name);
        Map result = new HashMap();
        if (amount == 0){
            int insertResult = roleService.insertRole(role_Name);
            if (insertResult == 1){
                result.put("result","操作成功");
            }else {
                result.put("result","操作失败");
            }
        }else {
            result.put("result","角色已存在");
        }
        return result;
    }

    /**
     * 点击删除，删除指定角色
     * */
    @ResponseBody
    @RequestMapping("/deleteTheRole")
    public Map deleteTheRole(String role_Name){
        int deleteResult = roleService.deleteTheRole(role_Name);
        Map result = new HashMap();
        if (deleteResult == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }

    /**
     * 查看角色权限
     * */
    @ResponseBody
    @RequestMapping("/selectThePower")
    public Map selectThePower(int role_ID){
        Map result = new HashMap();
        List<Power> powers = roleService.selectThePower(role_ID);
        result.put("powers",powers);
        return result;
    }

    /**
     * 增加角色权限（1.1、查看未授权权限）
     * */
    @ResponseBody
    @RequestMapping("/selectUnauthorizedPower")
    public Map selectUnauthorizedPower(int role_ID){
        Map result = new HashMap();
        List<Power> unauthorizedPower = roleService.selectUnauthorizedPower(role_ID);
        result.put("unauthorizedPowers", unauthorizedPower);
        return result;
    }
}
