package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.OnlineEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
