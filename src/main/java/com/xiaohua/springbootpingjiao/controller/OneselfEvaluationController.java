package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.service.OneselfEvaluationService;
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
    public Map selectOneselfEvaluation(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
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
    public Map selectBatchIdStudentEvaluation(int batch_id){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
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
    public Map selectIfOneselfEvaluation(int gradeds,int papers_id,int courses_id){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession session = request.getSession();
        int rater = Integer.parseInt(session.getAttribute("user_id").toString());
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
