package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.ResponseWrapper;
import com.xiaohua.springbootpingjiao.entity.User;
import com.xiaohua.springbootpingjiao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @author:xiaoyi
 * @date: 2019/9/19 14:13
 * @Description : 跳转主页
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService service;
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


    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/12 17:22
     * @param
     * @Description 跳转主页
     */
    @RequestMapping("gologin")
    public String login(){
        return "login";
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/26 11:48
    * @param
    * @Description 登录验证
    */
    @RequestMapping("validation")
    @ResponseBody
    public Map validation(String name, String password){
        User user  = new User();
        user.setUser_Password(password);
        user.setUser_Account(name);
        boolean result =service.loginUser(user);
        Map map = new HashMap();
        if (result){
            map.put("msg","true");
            return  map;
        }
        map.put("msg","false");
        return  map;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/27 11:47
    * @param
    * @Description 登出
    */
    @RequestMapping("loginOut")
    @ResponseBody
    public ResponseWrapper loginOut(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession  session = request.getSession();
        session.invalidate();
        return ResponseWrapper.loginOutSuccess();
    }
    
}


