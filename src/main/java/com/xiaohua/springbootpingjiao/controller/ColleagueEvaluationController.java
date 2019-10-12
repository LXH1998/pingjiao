package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.service.ColleagueEvaluationService;
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
 * @Date: 2019/9/25 23:27
 * @VERSION: 1.0
 **/
@Controller
@RequestMapping("/ColleagueEvaluation")
public class ColleagueEvaluationController {
    @Autowired
    private ColleagueEvaluationService colleagueEvaluationService;

    @RequestMapping("GoColleagueEvaluation")
    public String GoColleagueEvaluation(){
        return "admin/evaluation/colleagueEvaluation";
    }

    @ResponseBody
    @RequestMapping("selectColleagueEvaluation")
    public Map selectColleagueEvaluation(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
        Map result = new HashMap();
        List<HashMap> users = colleagueEvaluationService.selectColleagueEvaluation(user_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",users.size());
        result.put("data",users);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectBatchIdColleagueEvaluation")
    public Map selectBatchIdColleagueEvaluation(int batch_id){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
        Map result = new HashMap();
        List<HashMap> users = colleagueEvaluationService.selectBatchIdColleagueEvaluation(user_id,batch_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",users.size());
        result.put("data",users);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectIfEvaluation")
    public Map selectIfEvaluation(int gradeds,int papers_id,int courses_id){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int rater = Integer.parseInt(session.getAttribute("user_id").toString());
        Map result = new HashMap();
        List<HashMap> users = colleagueEvaluationService.selectIfEvaluation(rater, gradeds, papers_id, courses_id);
        if (users.size()>0){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("selectIfStartEvaluation")
    public Map  selectIfStartEvaluation(int batch_Id){
        Map result = new HashMap();
        List<Batch> batches = colleagueEvaluationService.selectIfStartEvaluation(batch_Id);
        String hide = batches.get(0).getBatch_Hide();
        if(hide.equals("1")){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }
}
