package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Role;
import com.xiaohua.springbootpingjiao.entity.User;
import com.xiaohua.springbootpingjiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/9/11 12:31
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/userAdministration")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("goIndex")
    public String GoIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("selectAllUser")
    public Map selectAllUser(int page,int limit){
        int pages=(page-1)*limit;
        Map result=new HashMap();
        List<HashMap> users = userService.selectAllUser(pages,limit);
        List<HashMap> count = userService.selectCount();
        result.put("code",0);
        result.put("msg","");
        result.put("count",count.size());
        result.put("data",users);
        return result;
    }

    @ResponseBody
    @RequestMapping("updateUserPassword")
    public Map updateUserPassword(int user_Id){
        Map result=new HashMap();
        if(userService.updateUserPassword(user_Id)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("updateUserState")
    public Map updateUserState(int user_Id){
        Map result=new HashMap();
        if(userService.updateUserState(user_Id)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("selectAccountUsers")
    public Map selectAccountUsers(String user_Account,String role_name,int page,int limit){
        int pages=(page-1)*limit;
        Map result=new HashMap();
        List<HashMap> users = userService.selectAccountUsers(user_Account,role_name,pages,limit);
        List<HashMap> count = userService.selectAccountUsersCount(user_Account,role_name);
        result.put("code",0);
        result.put("msg","");
        result.put("count",count.size());
        result.put("data",users);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectAllRole")
    public  Map selectAllRole(){
        Map result = new HashMap();
        List<Role> roles = userService.selectAllRole();
        result.put("data",roles);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectAllDepartments")
    public Map selectAllDepartments(){
        Map result = new HashMap();
        List<Departments> departments = userService.selectAllDepartments();
        result.put("data",departments);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectAllClass")
    public Map selectAllClass(int departments_Id){
        Map result = new HashMap();
        List<HashMap> classes = userService.selectAllClass(departments_Id);
        result.put("data",classes);
        return result;
    }

    @ResponseBody
    @RequestMapping("updateUserInformationRole")
    public Map updateUserInformationRole(String user_Name, String user_Account, String user_Sex,
                                     int departments_Id, int class_Id, String role_Id, int user_Id) {
        Map result = new HashMap();
        userService.deleteUserIdRole(user_Id);
        if(userService.updateUserInformation(user_Name,user_Account,user_Sex,departments_Id,class_Id,user_Id)){
            String a[]=role_Id.split(",");
            for (int i=0;i<a.length;i++) {
                String role_id = a[i];
                System.out.println(role_id);
                int role_ID = Integer.parseInt(role_id);
                if(userService.insertUserIdRole(user_Id,role_ID)){
                    result.put("data",1);
                }else{
                    result.put("data",0);
                }
            }
        }else{
            result.put("data",0);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("insertUserInformationRole")
    public Map insertUserInformationRole(String user_Name, String user_Account, String user_Sex,
                                         int departments_Id, int class_Id, String role_Id) {
        Map result = new HashMap();
        String a[]=role_Id.split(",");
        for (int i=0;i<a.length;i++){
            String role_id = a[i];
            System.out.println(role_id);
            int role_ID = Integer.parseInt(role_id);
            if(userService.insertUserInformation(user_Name,user_Account,user_Sex,departments_Id,class_Id)){
                List<User> userList = userService.selectUserId(user_Name,user_Account);
                int user_id = userList.get(0).getUser_Id();
                if (userService.insertUserRole(role_ID,user_id)){
                    result.put("data",1);
                }else{
                    result.put("data",0);
                }
            }else{
                result.put("data",0);
            }
        }

        return result;
    }


    @RequestMapping("goUserInterface")
    public String GoUserInterface(){
        return "admin/user/userInterface";
    }

    @RequestMapping("GoUpdateUser")
    public String GoUpdateUser(){
        return "admin/user/updateUser";
    }

    @RequestMapping("GoAddUser")
    public String GoAddUser(){
        return "admin/user/addUser";
    }

    @ResponseBody
    @RequestMapping("selectUserHaveRole")
    public Map selectUserHaveRole(int user_id){
        Map result=new HashMap();
        List<HashMap> users = userService.selectUserHaveRole(user_id);
        result.put("data",users);
        return result;
    }

    @ResponseBody
    @RequestMapping("/selectUserIfRepeat")
    public Map selectUserIfRepeat(String user_account){
        Map result=new HashMap();
        List<HashMap> users = userService.selectUserIfRepeat(user_account);
        if(users.size()>0){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }
}
