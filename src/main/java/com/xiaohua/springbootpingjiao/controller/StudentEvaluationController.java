package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.service.StudentEvaluationService;
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
    public Map selectStudentEvaluation(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
        Map result = new HashMap();
        List<HashMap> student = studentEvaluationService.selectStudentEvaluation(user_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",student.size());
        result.put("data",student);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectBatchName")
    public  Map selectBatchName(){
        Map result = new HashMap();
        List<Batch> batches = studentEvaluationService.selectBatchName();
        result.put("data",batches);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectBatchIdStudentEvaluation")
    public Map selectBatchIdStudentEvaluation(int batch_id){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
        Map result = new HashMap();
        List<HashMap> student = studentEvaluationService.selectBatchIdStudentEvaluation(user_id,batch_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",student.size());
        result.put("data",student);
        return result;
    }
}
