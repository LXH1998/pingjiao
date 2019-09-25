package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.StudentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/9/23 21:04
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/StudentEvaluation")
public class StudentEvaluationController {
    @Autowired
    private StudentEvaluationService studentEvaluationService;

    @RequestMapping("GoStudentEvaluation")
    public String GoStudentEvaluation(){
        return "admin/evaluation/studentEvaluation";
    }

    @ResponseBody
    @RequestMapping("selectStudentEvaluation")
    public Map selectStudentEvaluation(int user_id){
        Map result = new HashMap();
        List<HashMap> student = studentEvaluationService.selectStudentEvaluation(user_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",student.size());
        result.put("data",student);
        return result;
    }
}
