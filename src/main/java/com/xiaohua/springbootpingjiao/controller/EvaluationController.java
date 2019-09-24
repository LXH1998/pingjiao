package com.xiaohua.springbootpingjiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: luquanlin
 * @Date: 2019/9/23 21:04
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/Evaluation")
public class EvaluationController {
    @RequestMapping("GoStudentEvaluation")
    public String GoStudentEvaluation(){
        return "admin/evaluation/studentEvaluation";
    }
}
