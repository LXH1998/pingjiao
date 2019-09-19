package com.xiaohua.springbootpingjiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: LoginController
 * @author:xiaoyi
 * @date: 2019/9/19 14:13
 * @Description : 跳转主页
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {
    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/12 17:22
     * @param
     * @Description 跳转主页
     */
    @RequestMapping("goIndex")
    public String goIndex(){
        return "index";
    }
}

