package com.xiaohua.springbootpingjiao.controller;


import com.xiaohua.springbootpingjiao.entity.WaterPojo;
import com.xiaohua.springbootpingjiao.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("stats")
public class StatsController {
    @Autowired
    private StatsService service;
    @RequestMapping("goIndex")
    public String goStatsIndex(){
        return "/admin/stats/stats_index";
    }
    @RequestMapping("godetails")
    public String goSstatsDetails(){
        return "/admin/stats/stats_details";
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 10:22
    * @param
    * @Description 统计评分 将其插入总分表
    */
    @ResponseBody
    @RequestMapping("/cc")
    public List<WaterPojo> ccc(String batchId){
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
    @RequestMapping("/evaluationTop")
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
    @RequestMapping("/queryPie")
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
    @RequestMapping("/queryBatchsList")
    public List<HashMap> queryBatchsList(String papersId){
        HashMap map = new HashMap();
        if(papersId != null && papersId.length()!=0&&papersId != ""){
            map.put("papersId",papersId);
        }else{
            map.put("papersId","null");
        }
        List<HashMap> list = service.queryPapersList(map);
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
    @RequestMapping("/queryPapersList")
    public List<HashMap> queryPapersList(String batchId){
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0&&batchId!=""){
            map.put("batchId",batchId);
        }else {
            map.put("batchId","null");
        }
        List<HashMap> list = service.queryBatchsList(map);
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
    @RequestMapping("/querySocoreLimit5")
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
    @RequestMapping("/querySocore")
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
}
