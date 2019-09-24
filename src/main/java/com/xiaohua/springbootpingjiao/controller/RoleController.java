package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
     * 点击权限按钮，弹出权限弹窗
     */
    @RequestMapping("/zTree")
    public String zTree(){
        return "admin/role/role_power";
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
     *显示角色权限（树的形式）
     */
    @ResponseBody
    @RequestMapping("/checkTest")
    public List getTreeList(int role_ID){
//        查出所有权限
        List<Power> powerList = roleService.selectAllPower();
//        查出角色拥有的权限
        List<Power> powers = roleService.selectThePower(role_ID);
//        创建List集合，用来存储数据
        List<Map<String,Object>> list = new ArrayList<>();
//        遍历list数据
        for (Power plist:powerList){
//            创建Map集合
            Map<String,Object> map = new HashMap<>();
            map.put("id",plist.getPower_Id());
            map.put("pId",plist.getPower_parentid());
            map.put("name",plist.getPower_Name());
//            判断当前角色是否拥有p菜单，如果有，默认选中的状态
            for (Power p:powers){
                if (p.getPower_Id()==plist.getPower_Id()){
//                    System.out.println("测试");
                    map.put("checked","true");
                    break;
                }else {
                    map.put("checked","false");
                }
            }
//            把map存入list集合中
            list.add(map);
        }
        return list;
    }



    /**
     * zTree修改角色权限
     */
    @ResponseBody
    @RequestMapping("/insertThePowers")
    public Map insertThePowers(String codeId,int role_Id){
        boolean isdelete = deleteThePowerTest(role_Id);
        Map result = new HashMap();
        if (isdelete == true){
            List<Power> powers = roleService.selectTheDeletePower(role_Id);
            String powerIds[]=codeId.split(",");
            try {
                for (int i=0;i<powerIds.length;i++){
                    String powerId = powerIds[i];
                    int power_Id = Integer.valueOf(powerId);
                    int isupdate = roleService.updateTheDeletePowerTest(role_Id,power_Id);
                        if (isupdate == 0){
                            roleService.insertRolePower(role_Id,power_Id);
                            result.put("code",1);
                        }else {
                            result.put("code",1);
                        }
                }
            }catch (Exception e){
                e.printStackTrace();
                result.put("code", -1);
            }
        }else {
            result.put("code", -1);
        }
        return result;
    }

    /**
     * 删除角色权限
     */
    public boolean deleteThePowerTest(int role_Id){
        int test = roleService.deleteThePowerTest(role_Id);
        boolean istrue = false;
        if (test != 0){
            istrue = true;
        }
        return istrue;
    }

}
