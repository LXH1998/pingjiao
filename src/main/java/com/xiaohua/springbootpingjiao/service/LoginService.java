package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginService {

    boolean loginUser(User u, HttpSession session);
}
