package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.FractionSum;
import com.xiaohua.springbootpingjiao.service.OnlineEvaluationService;
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
 * @Date: 2019/9/26 10:56
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/OnlineEvaluationController")
public class OnlineEvaluationController {
    @Autowired
    private OnlineEvaluationService onlineEvaluationService;

    @RequestMapping("GoOnlineEvaluation")
    public String GoOnlineEvaluation(){
        return "admin/evaluation/onlineEvaluation";
    }

    @ResponseBody
    @RequestMapping("selectOnlineEvaluation")
    public Map selectOnlineEvaluation(int papers_id){
        Map result=new HashMap();
        List<Map<String, Object>> online = onlineEvaluationService.selectOnlineEvaluation(papers_id);
        result.put("data",online);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectHistoryOnlineEvaluation")
    public Map selectHistoryOnlineEvaluation(int papers_id){
        Map result=new HashMap();
        List<Map<String, Object>> online = onlineEvaluationService.selectHistoryOnlineEvaluation(papers_id);
        result.put("data",online);
        return result;
    }

    @ResponseBody
    @RequestMapping("OnlineEvaluationFraction")
    public Map OnlineEvaluationFraction(String optionsAll_id,int gradeds,int papers_id,int courses_id,String answers,String target_name_id){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int rater = Integer.parseInt(session.getAttribute("user_id").toString());
        String a[]=optionsAll_id.split(",");
        String t[]=target_name_id.split(",");
        Map result =new HashMap();
        float sum = 0;
        for (int i=0;i<a.length;i++){
            String options = a[i];
            String targets_id = t[i];
            int options_id = Integer.parseInt(options);
            int target_id = Integer.parseInt(targets_id);
            FractionSum fractionSum = new FractionSum();
            List<FractionSum> fractions = onlineEvaluationService.OnlineEvaluationFraction(options_id,target_id,papers_id);
            sum = sum + fractions.get(0).getFraction();
        }
        String fractions = String.valueOf(sum);
        System.out.println(sum);
        String b= '"'+answers+'"';
        if(onlineEvaluationService.insertOnlineEvaluation(rater,gradeds,papers_id,courses_id,b,fractions)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }

        return result;
    }
}
