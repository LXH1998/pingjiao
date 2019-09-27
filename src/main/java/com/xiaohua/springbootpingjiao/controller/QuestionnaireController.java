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

    @ResponseBody
    @RequestMapping("/QuestionnaireAll")
    public HashMap selectClassWhereCdId(String class_Id, String departments_id, int page, int limit){
        int pages = (page-1)*limit;
        HashMap result = new HashMap();
        List<HashMap> classes = QuestionnaireService.selectQuestionnaire(pages,limit);

        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
       result.put("data",classes);
        return result;
    }

    @RequestMapping("Questionnaire")
    public String details(){ return "admin/Questionnaire/Questionnaire"; }

}
