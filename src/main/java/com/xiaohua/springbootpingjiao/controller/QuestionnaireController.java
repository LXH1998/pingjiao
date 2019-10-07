package com.xiaohua.springbootpingjiao.controller;


import com.xiaohua.springbootpingjiao.entity.Papers;
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
    public HashMap selectClassWhereCdId( int page, int limit){
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
    //查询角色
    @ResponseBody
    @RequestMapping("/selectuser")
    public HashMap selectuser(){
        HashMap result = new HashMap();
        List<HashMap<String,String>> classes = QuestionnaireService.selectuser();
        result.put("code",0);
        result.put("msg","");
        result.put("count",classes.size());
        result.put("data",classes);
        return result;
    }

//搜索用户重载表格
@ResponseBody
@RequestMapping("/selectQuestionnaireinName")
public HashMap selectQuestionnaireinName(String papers_name,int page, int limit){
    int pages = (page-1)*limit;
    HashMap result = new HashMap();
    List<HashMap<String,String>> classes = QuestionnaireService.selectQuestionnaireinName(papers_name,pages,limit);
    List<HashMap<String,String>> classescount = QuestionnaireService.selectQuestionnaireinNameCount(papers_name);
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

//指定批次重载表格
@ResponseBody
@RequestMapping("/selectQuestionnaireinBatch")
public HashMap selectQuestionnaireinBatch(String batch_id,int page, int limit){
    int pages = (page-1)*limit;
    HashMap result = new HashMap();
    List<HashMap<String,String>> classes = QuestionnaireService.selectQuestionnaireinBatch(batch_id,pages,limit);
    List<HashMap<String,String>> classescount = QuestionnaireService.selectQuestionnaireinBatchCount(batch_id);
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

    //指定角色重载表格
    @ResponseBody
    @RequestMapping("/selectQuestionnaireinRoleid")
    public HashMap selectQuestionnaireinRoleid(String role_id,int page, int limit){
        int pages = (page-1)*limit;
        HashMap result = new HashMap();
        List<HashMap<String,String>> classes = QuestionnaireService.selectQuestionnaireinRoleid(role_id,pages,limit);
        List<HashMap<String,String>> classescount = QuestionnaireService.selectQuestionnaireinRoleidCount(role_id);
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

    //指定批次和角色重载表格
    @ResponseBody
    @RequestMapping("/selectQuestionnaireinBR")
    public HashMap selectQuestionnaireinBR(String role_id,String batch_id,int page, int limit){
        int pages = (page-1)*limit;
        HashMap result = new HashMap();
        List<HashMap<String,String>> classes = QuestionnaireService.selectQuestionnaireinBR(role_id,batch_id,pages,limit);
        List<HashMap<String,String>> classescount = QuestionnaireService.selectQuestionnaireinBRCount(role_id,batch_id);
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


    @ResponseBody
    @RequestMapping("/deletePapers")
    public  boolean deletePapers(String papers_Id){
        Papers c = new Papers();
        c.setPapers_Id(Integer.parseInt(papers_Id));
        boolean flag = QuestionnaireService.deletePapers(c);
        if (flag){
            return   true;
        }
        return  false;

    }


    @RequestMapping("Questionnaire")
    public String details(){ return "admin/Questionnaire/Questionnaire"; }

    @RequestMapping("addQuestionnaire")
    public String addQuestionnaire(){ return "admin/Questionnaire/addQuestionnaire"; }

}
