package com.xiaohua.springbootpingjiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * TargetController
 *
 * @author zuojie
 * @version 1.0
 * @Date 2019/9/25 0025
 * @Time 8:51
 **/
@Controller
@RequestMapping("/TargetManagement")
public class TargetController {

//    跳转指标管理选项卡
    @RequestMapping("/toIndex")
    public String toTargetManagement(){
        return "admin/target/target_test";
    }


    public Map targetTree(){
        Map result = new HashMap();

        return result;
    }
}
