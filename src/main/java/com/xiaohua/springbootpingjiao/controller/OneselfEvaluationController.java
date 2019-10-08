package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.service.OneselfEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/OneselfEvaluation")
public class OneselfEvaluationController {
    @Autowired
    private OneselfEvaluationService oneselfEvaluationService;

    @RequestMapping("GoOneselfEvaluation")
    public String GoOneselfEvaluation(){
        return "admin/evaluation/oneselfEvaluation";
    }

    @ResponseBody
    @RequestMapping("selectOneselfEvaluation")
    public Map selectOneselfEvaluation(int user_id){
        Map result = new HashMap();
        List<HashMap> users = oneselfEvaluationService.selectOneselfEvaluation(user_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",users.size());
        result.put("data",users);
        return result;
    }

//    @ResponseBody
//    @RequestMapping("selectBatchName")
//    public  Map selectBatchName(){
//        Map result = new HashMap();
//        List<Batch> batches = oneselfEvaluationService.selectBatchName();
//        result.put("data",batches);
//        return result;
//    }

    @ResponseBody
    @RequestMapping("selectBatchIdOneselfEvaluation")
    public Map selectBatchIdStudentEvaluation(int user_id,int batch_id){
        Map result = new HashMap();
        List<HashMap> users = oneselfEvaluationService.selectBatchIdOneselfEvaluation(user_id,batch_id);
        result.put("code",0);
        result.put("msg","");
        result.put("count",users.size());
        result.put("data",users);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectIfOneselfEvaluation")
    public Map selectIfOneselfEvaluation(int rater,int gradeds,int papers_id,int courses_id){
        Map result = new HashMap();
        List<HashMap> users = oneselfEvaluationService.selectIfOneselfEvaluation(rater, gradeds, papers_id, courses_id);
        if (users.size()>0){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }
}
