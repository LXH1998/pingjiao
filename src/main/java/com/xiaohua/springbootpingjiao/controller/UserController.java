package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("goIndex")
    public String GoIndex(){
        return "index";
    }
    @RequestMapping("goAdminIndex")
    public String goAdminIndex(){
        return "indexAdmin";
    }

    @ResponseBody
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }
}
