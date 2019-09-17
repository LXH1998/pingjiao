package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("goIndex")
    public String GoIndex(){
        return "index";
    }
    @RequestMapping("goA")
    public String goAdminIndex(){
        return "a";
    }
    @RequestMapping("goB")
    public String goAdminIndex1(){
        return "b";
    }
    @RequestMapping("UserList")
    public String UserList(){
        return "admin/course/course_list";
    }

    @ResponseBody
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }
}
