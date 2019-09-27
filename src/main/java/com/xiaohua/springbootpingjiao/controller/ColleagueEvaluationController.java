package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.ColleagueEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map selectColleagueEvaluation(int user_id){
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
    public Map selectBatchIdColleagueEvaluation(int user_id,int batch_id){
        Map result = new HashMap();
        List<HashMap> users = colleagueEvaluationService.selectBatchIdColleagueEvaluation(user_id,batch_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",users.size());
        result.put("data",users);
        return result;
    }
}
