package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Fraction;
import com.xiaohua.springbootpingjiao.service.SelectOnlineEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/7 16:46
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/SelectOnlineEvaluationController")
public class SelectOnlineEvaluationController {
    @Autowired
    private SelectOnlineEvaluationService selectOnlineEvaluationService;

    @RequestMapping("GoSelectOnlineEvaluation")
    public String GoSelectOnlineEvaluation(){
        return "/admin/evaluation/selectOnlineEvaluation";
    }

    @ResponseBody
    @RequestMapping("selectIfEvaluation")
    public Map selectIfEvaluation(int rater, int gradeds, int papers_id, int courses_id){
        Map result=new HashMap();
        List<Fraction> fractions = selectOnlineEvaluationService.selectEvaluationAnswers(rater, gradeds, papers_id, courses_id);
        result.put("data",fractions);
        return result;
    }
}
