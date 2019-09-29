package com.xiaohua.springbootpingjiao.controller;


import com.xiaohua.springbootpingjiao.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Questionnaire")
public class QuestionnaireController {

    @Autowired
    public QuestionnaireService QuestionnaireService;
//查询问卷信息
    @ResponseBody
    @RequestMapping("/QuestionnaireAll")
    public HashMap selectClassWhereCdId(String class_Id, String departments_id, int page, int limit){
        int pages = (page-1)*limit;
        HashMap result = new HashMap();
        List<HashMap<String,String>> classes = QuestionnaireService.selectQuestionnaire(pages,limit);
        List<HashMap<String,String>> classescount = QuestionnaireService.selectQuestionnaireCount();
       for ( HashMap str:classes){
           if (str.get("batch_hide").equals("0")){
               str.put("batch_hide","关闭");
           }else if (str.get("batch_hide").equals("1")){
               str.put("batch_hide","开启");
           }else {
               str.put("batch_hide","结束");
           }
//           result.put("batch_hide")
       };
        result.put("code",0);
        result.put("msg","");
        result.put("count",classescount.size());
       result.put("data",classes);
        return result;
    }

    //查询批次
    @ResponseBody
    @RequestMapping("/selectbatch")
    public HashMap selectbatch(){

        HashMap result = new HashMap();
        List<HashMap<String,String>> classes = QuestionnaireService.selectbatch();
        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
        result.put("data",classes);
        return result;
    }


    @RequestMapping("Questionnaire")
    public String details(){ return "admin/Questionnaire/Questionnaire"; }

}
