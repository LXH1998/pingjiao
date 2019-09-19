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

    /**
     * 主页
     */
    @RequestMapping("/goIndex")
    public String goIndex(){
        return "index";
    }

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
     * 添加权限弹窗
     */
    @RequestMapping("/goAddPower")
    public String goAddPower(){
        return "admin/role/role_addPower";
    }


    /**
     * 管理员点击角色管理，首先查询角色表所有角色，将数据返回页面
     * */
    @ResponseBody
    @RequestMapping("/allRoles")
    public Map selectAllRoles(int page,int limit){
        int thePage = (page-1)*limit;
        Map result = new HashMap();
        List<Role> count = roleService.selectAllRoles();
        List<Role> roles = roleService.selectOnePageRoles(thePage,limit);
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",count.size());
        result.put("data",roles);
        return result;
    }

    /**
     * 角色查询
     * @param role_Name
     * @return
     */
    @ResponseBody
    @RequestMapping("/searchRole")
    public Map searchRole(String role_Name,int page,int limit){
        int thePage = (page-1)*limit;
        Map result = new HashMap();

        List<Role> count = roleService.searchRole(role_Name);
        List<Role> roles = roleService.searchTheOnePageRole(role_Name,thePage,limit);

        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",count.size());
        result.put("data",roles);
        return result;
    }

    /**
     * 增加角色
     * */
    @ResponseBody
    @RequestMapping("/insertRole")
    public Map insertRole(String role_Name){
        int roles = roleService.selectTheRole(role_Name);
        Map result = new HashMap();
        if (roles==0){
            int insertResult = roleService.insertRole(role_Name);
            if (insertResult == 1){
                result.put("result","操作成功");
            }else {
                result.put("result","操作失败");
            }
        }else{
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
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/deleteRoles")
    public Map deleteRoles(String codeName){
        Map result = new HashMap();
        String a[]=codeName.split(",");
        try {
            for (int i=0;i<a.length;i++){
                String role_Name = a[i];
                roleService.deleteTheRole(role_Name);
                result.put("code",1);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("code", -1);
        }

        return result;
    }

    /**
     * 查看角色权限
     * */
    @ResponseBody
    @RequestMapping("/selectThePower")
    public Map selectThePower(int role_ID,int page,int limit){
        int thePage = (page-1)*limit;
        Map result = new HashMap();
        List<Power> count = roleService.selectThePower(role_ID);
        List<Power> powers = roleService.selectOnePagePower(role_ID,thePage,limit);
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",count.size());
        result.put("data",powers);
        return result;
    }

    /**
     * 增加角色权限（1.1、查看未授权权限）
     * */
    @ResponseBody
    @RequestMapping("/selectUnauthorizedPower")
    public Map selectUnauthorizedPower(int role_ID,int page,int limit){
        int thePage = (page-1)*limit;
        Map result = new HashMap();
        List<Power> count = roleService.selectUnauthorizedPower(role_ID);
        List<Power> unauthorizedPower = roleService.selectOnePageUnauthorizedPower(role_ID,thePage,limit);
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",count.size());
        result.put("data",unauthorizedPower);
        return result;
    }
    /**
     * 增加角色权限（1.2、增加角色权限）
     */
    @ResponseBody
    @RequestMapping("/insertRolePower")
    public Map insertRolePower(int role_Id,int power_Id){
        Map result = new HashMap();
        int insert = roleService.insertRolePower(role_Id,power_Id);
        if (insert==1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }

    /**
     * 删除角色权限
     */
    @ResponseBody
    @RequestMapping("/deleteThePower")
    public Map deleteThePower(int role_Id,int power_Id){
        Map result = new HashMap();
        int del = roleService.deleteThePower(role_Id,power_Id);
        if (del==0){
            result.put("data","操作失败");
        }else if (del==1){
            result.put("data","操作成功");
        }
        return result;
    }
}
