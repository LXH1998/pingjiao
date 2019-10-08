package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.FractionSum;
import com.xiaohua.springbootpingjiao.service.OnlineEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
    @RequestMapping("OnlineEvaluationFraction")
    public Map OnlineEvaluationFraction(String optionsAll_id,int rater,int gradeds,int papers_id,int courses_id,String answers){
        String a[]=optionsAll_id.split(",");
        Map result =new HashMap();
        float sum = 0;
        for (int i=0;i<a.length;i++){
            String options = a[i];
            int options_id = Integer.parseInt(options);
            FractionSum fractionSum = new FractionSum();
            List<FractionSum> fractions = onlineEvaluationService.OnlineEvaluationFraction(options_id);
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
