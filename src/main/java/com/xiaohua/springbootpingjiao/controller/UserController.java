package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Role;
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
@RequestMapping("/testBoot")
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
    public Map selectAccountUsers(String user_Account,String role_name){
        Map result=new HashMap();
        List<HashMap> users = userService.selectAccountUsers(user_Account,role_name);
        result.put("code",0);
        result.put("msg","");
        result.put("count",users.size());
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

    @RequestMapping("goUserInterface")
    public String GoUserInterface(){
        return "admin/user/userInterface";
    }

    @RequestMapping("GoUpdateUser")
    public String GoUpdateUser(){
        return "admin/user/updateUser";
    }

}
