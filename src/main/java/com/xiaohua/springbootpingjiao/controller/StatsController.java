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
    public List<WaterPojo> ccc(){
        List<WaterPojo> list =  service.clearUpFraction("1","1");
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
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0){
            map.put("batchId",batchId);
        }
        if(papersId != null && papersId.length()!=0){
            map.put("papersId",papersId);
        }
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
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0){
            map.put("batchId",batchId);
        }
        if(papersId != null && papersId.length()!=0){
            map.put("papersId",papersId);
        }

        List<HashMap> list = service.queryPie(map);
        return  list;
    }
    @ResponseBody
    @RequestMapping("/queryDeapratmentLike")
    public List<HashMap> dddd(String batchId,String papersId){
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0){
            map.put("batchId",batchId);
        }
        if(papersId != null && papersId.length()!=0){
            map.put("papersId",papersId);
        }
        List<HashMap> list = service.queryDepartmentLike(map);
        return list;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 10:01
    * @param
    * @Description
    */
    @ResponseBody
    @RequestMapping("/queryBatch")
    public HashMap queryBatch(){
        HashMap map = new HashMap();
        List<HashMap> list = service.queryBatch();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 10:10
    * @param
    * @Description
    */
    @ResponseBody
    @RequestMapping("/queryPaper")
    public HashMap queryPaper(){
        HashMap map = new HashMap();
        List<HashMap> list = service.queryPaper();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    @ResponseBody
    @RequestMapping("/queryScoreDealits")
    public HashMap queryScoreDealits(String batchId,String papersId){
        HashMap map = new HashMap();
        if(batchId != null && batchId.length()!=0){
            map.put("batchId",batchId);
        }
        if(papersId != null && papersId.length()!=0){
            map.put("papersId",papersId);
        }
        List<HashMap> list = service.queryScoreDealits(map);
        HashMap map1 = new HashMap();
        map1.put("code",0);
        map1.put("msg","");
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

}
