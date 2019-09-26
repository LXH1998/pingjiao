package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.User;
import com.xiaohua.springbootpingjiao.mapper.LoginMapper;
import com.xiaohua.springbootpingjiao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;

/**
 * @ClassName: LoginServiceImpl
 * @author:xiaoyi
 * @date: 2019/9/26 11:58
 * @Description :
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/26 12:01
    * @param
    * @Description 登录验证
    */
    @Override
    public boolean loginUser(User u,HttpSession session) {
        List<User>  list = loginMapper.loginUser(u);
        if (!list.isEmpty()){
            session.setAttribute("user_id",list.get(0).getUser_Id());
            return  true;
        }
        return  false;
    }
}
