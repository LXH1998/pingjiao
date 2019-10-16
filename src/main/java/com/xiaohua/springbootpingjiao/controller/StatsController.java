package com.xiaohua.springbootpingjiao.controller;


import com.xiaohua.springbootpingjiao.entity.Fraction;
import com.xiaohua.springbootpingjiao.entity.WaterPojo;
import com.xiaohua.springbootpingjiao.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatisticalController
 * @author:xiaoyi
 * @date: 2019/9/28 15:16
 * @Description : 统计分析Controller
 */
@Controller
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    private StatsService service;

    @RequestMapping("/goIndex")
    public String goStatsIndex(){
        return "admin/stats/stats_index";
    }
    @RequestMapping("/godetails")
    public String goSstatsDetails(){
        return "admin/stats/stats_details";
    }
    @RequestMapping("/godetailsList")
    public String goDetailsList(){
        return "admin/stats/stats_details_list";
    }
    @RequestMapping("/testList")
    public String GoSelectOnlineEvaluation(){
        return "admin/stats/testList";
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 10:22
    * @param
    * @Description 统计评分 将其插入总分表
    */
    @ResponseBody
    @RequestMapping("cc")
    public List<WaterPojo> ccc(){
        List<WaterPojo> list =  service.clearUpFraction("1");
        return list;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/5 10:44
    * @param
    * @Description 顶部信息
    */
    @ResponseBody
    @RequestMapping("evaluationTop")
    public List<HashMap> ddd(String batchId,String papersId){
        HashMap map = hashmapB(batchId,papersId);
        List<HashMap> listA =  service.queryScoreDepartment(map);
        List<HashMap> listB =  service.queryScoreTeacher(map);
        List<HashMap> listC =  service.queryScoreMan(map);
        List<HashMap> listD =  service.queryAverageTeacherDayu(map);
        List list = new ArrayList();
        list.add(listA);
        list.add(listB);
        list.add(listC);
        list.add(listD);
        return list;
    }
    @ResponseBody
    public HashMap hashmapB(String batchId,String papersId){
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0){
            map.put("batchId",batchId);
        }
        if(papersId != null && papersId.length()!=0){
            map.put("papersId",papersId);
        }
        return  map;
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/5 10:44
    * @param
    * @Description 底部饼图生成
    */
    @ResponseBody
    @RequestMapping("queryPie")
    public List<HashMap> QueryPie(String batchId,String papersId){
        HashMap map = hashmapB(batchId,papersId);
        List<HashMap> list = service.queryPie(map);
        return  list;
    }

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/10/10 9:50
     * @param
     * @Description 二级联动查询批次
     *
     */
    @ResponseBody
    @RequestMapping("queryBatchsList")
    public List<HashMap> queryBatchsList(String papersId){
        HashMap map = new HashMap();
        if(papersId != null && papersId.length()!=0&&papersId != ""){
            map.put("papersId",papersId);
        }
        List<HashMap> list = service.queryBatchsList(map);
        return  list;
    }

    @ResponseBody
    @RequestMapping("queryBaticNameList")
    public List<HashMap> queryBaticNameList(String batchId){
        List<HashMap> list = service.queryBaticNameList(batchId);
        return  list;
    }


    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/10/10 9:50
     * @param
     * @Description 二级联动查询问卷
     *
     */
    @ResponseBody
    @RequestMapping("queryPapersList")
    public List<HashMap> queryPapersList(String batchId){
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0&&batchId!=""){
            map.put("batchId",batchId);
        }
        List<HashMap> list = service.queryPapersList(map);
        return  list;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/10 15:04
    * @param
    * @Description 取评教成绩前5
    */
    @ResponseBody
    @RequestMapping("querySocoreLimit5")
    public List<HashMap> querySocoreLimit5(String batchId,String papersId){
        HashMap map = hashmapB(batchId,papersId);
        List<HashMap> list = service.querySocoreLimit5(map);
        return  list;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/10 16:44
    * @param
    * @Description 查询成绩
    */
    @ResponseBody
    @RequestMapping("querySocore")
    public HashMap querySocore(String batchId,String papersId,int page,int limit){
        HashMap map = hashmapB(batchId,papersId);
        int pageing = (page-1)*limit;
        map.put("page",Integer.toString(pageing));
        map.put("limit",Integer.toString(limit));
        List<HashMap> list = service.querySocore(map);
        List<HashMap> size = service.queryScoreSize(map);
        int count = size.size();
        HashMap result = hashmapB(batchId,papersId);
        result.put("code",0);
        result.put("msg","");
        result.put("count",count);
        result.put("data",list);
        return  result;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/12 9:17
    * @param
    * @Description 查询某老师 课程成绩
    */
    @ResponseBody
    @RequestMapping("queryTeacherScore")
    public HashMap queryTeacherScore(String batchId,String papersId,int page,int limit,String gradeds){
        HashMap map = hashmapB(batchId,papersId);
        int pageing = (page-1)*limit;
        map.put("page",Integer.toString(pageing));
        map.put("limit",Integer.toString(limit));
        map.put("gradeds",gradeds);

        List<HashMap> teacherList = service.queryTeacherScore(map);

        List<HashMap> size = service.queryTeacherScoreSize(map);
        int count = size.size();
        HashMap res = hashmapB(batchId,papersId);
        HashMap map1  = new HashMap();
        map1.put("code",0);
        map1.put("msg","");
        map1.put("count",count);
        map1.put("data",teacherList);
        return  map1;
    }

    @ResponseBody
    @RequestMapping("querydetail")
    public HashMap querydetail(String batchId,String papersId,int page,int limit,int gradeds,int courses_id){
        HashMap map = hashmapB(batchId,papersId);
        int pageing = (page-1)*limit;
        map.put("page",Integer.toString(pageing));
        map.put("limit",Integer.toString(limit));
        map.put("gradeds",gradeds);
        map.put("courses_id",courses_id);
        List<HashMap> teacherList = service.querydetail(map);
        List<HashMap> size = service.querydetailSize(map);
        int count = size.size();
        HashMap res = hashmapB(batchId,papersId);
        HashMap map1  = new HashMap();
        map1.put("code",0);
        map1.put("msg","");
        map1.put("count",count);
        map1.put("data",teacherList);
        return  map1;
    }

    @ResponseBody
    @RequestMapping("selectIfEvaluation")
    public Map selectIfEvaluation(int gradeds, int papers_id, int courses_id,int rater ){
        Map result=new HashMap();
        List<Fraction> fractions = service.selectEvaluationAnswers(rater, gradeds, papers_id, courses_id);
        result.put("data",fractions);
        return result;
    }

    @ResponseBody
    @RequestMapping("selectFractions")
    public Map selectFractions(int gradeds,int papers_id,int courses_id, int rater){
        Map result=new HashMap();
        List<HashMap> fractions = service.selectFractions(rater, gradeds, papers_id, courses_id);
        result.put("data",fractions);
        return result;
    }

    @RequestMapping("look")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.addObject("batchId", "1");
        mv.setViewName("/admin/stats/stats_index");
        return mv;
    }


}
