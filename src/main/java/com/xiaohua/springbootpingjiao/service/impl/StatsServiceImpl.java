package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Scores;
import com.xiaohua.springbootpingjiao.entity.WaterPojo;
import com.xiaohua.springbootpingjiao.mapper.StatsMapper;
import com.xiaohua.springbootpingjiao.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: StatsServiceImpl
 * @author:xiaoyi
 * @date: 2019/9/29 10:13
 * @Description :
 */
@Service
public class StatsServiceImpl  implements StatsService {
    @Autowired
    private StatsMapper statsMapper;

    /**
    * @Author xiaoyi
    * @Return 
    * @Date 2019/10/4 10:22
    * @param 
    * @Description
    */
    @Override
    public List<WaterPojo> clearUpFraction(String batchId) {
        HashMap map = new HashMap();
        map.put("batchId",batchId);
        List<WaterPojo> list = statsMapper.clearUpFraction(map);
        int result = statisticalFraction(list,batchId);
        return list;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 11:33
    * @param
    * @Description 统计平价
    */
    @Override
    public int statisticalFraction(List<WaterPojo> list,String batchId) {
        HashMap mapOne = new HashMap();
        mapOne.put("batchId",batchId);
        double studentFraction = 0;
        double teacherFraction = 0;
        double num = 0;
        List<Scores> statisticalDemo = new ArrayList<Scores>();

        List<HashMap> papers_IdList =  statsMapper.queryPapers(mapOne);
        Integer papersId;
        for (HashMap papers_Idmap :papers_IdList ){
            papersId = Integer.parseInt(papers_Idmap.get("papers_id").toString());
            HashMap mapTwo = new HashMap();
            mapTwo.put("batchId",batchId);
            mapTwo.put("papersId",papersId);
            List<HashMap> ID = statsMapper.queryTeacherStats(mapTwo);
            List<WaterPojo> listPapers  = list.stream().filter(o -> o.getPapers_id().equals(papers_Idmap.get("papers_id"))).collect(Collectors.toList());
            for (HashMap map : ID){
                List<WaterPojo> listA  = listPapers.stream().filter(o -> o.getUser_id().equals(map.get("gradeds"))).collect(Collectors.toList());
                HashMap hashMap = new HashMap();
                hashMap.put("batchId",batchId);
                hashMap.put("gradeds",map.get("gradeds"));
                hashMap.put("papersId",papersId);
                    List<WaterPojo> listStudent  = listA.stream().filter(o -> o.getRole_name().equals("学生")).collect(Collectors.toList());

                    for(WaterPojo demo:listStudent){
                        studentFraction = studentFraction + demo.getFractions();
                    }
                    List<WaterPojo> listTeacher  = listA.stream().filter(o -> o.getRole_name().equals("教师")).collect(Collectors.toList());

                    for(WaterPojo demo:listTeacher){
                        teacherFraction = teacherFraction + demo.getFractions();
                    }
                    int f = list.size();
                    num = (studentFraction*0.4+teacherFraction*0.6);
                    Scores scores = new Scores();
                    Object teacherId = map.get("gradeds");
                    scores.setGradeds_Id(Integer.parseInt(teacherId.toString()));
                    scores.setPapers_id(papersId);
                    scores.setStudents_sum(studentFraction*0.4);
                    scores.setTeahcer_sum(teacherFraction*0.6);
                    scores.setBatch_id(Integer.parseInt(batchId));
                    num = (double) Math.round(num * 100) / 100;
                    scores.setScores_Sum(num);
                    statisticalDemo.add(scores);
                    num = 0;
                    teacherFraction = 0;
                    studentFraction = 0;
            }
        }



        int result = statsMapper.insertBatchScore(statisticalDemo);
        return result;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 14:29
    * @param
    * @Description 统计参与评教学院
    */
    @Override
    public List<HashMap> queryScoreDepartment(HashMap map) {
        List<HashMap> list = statsMapper.queryScoreDepartment(map);
        return list;
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/4 14:20
    * @param
    * @Description 查询参与评教老师
    */
    @Override
    public List<HashMap> queryScoreTeacher(HashMap map) {
        List<HashMap> list = statsMapper.queryScoreTeacher(map);
        return list;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/5 10:08
    * @param
    * @Description 查询评价人数
    */
    @Override
    public List<HashMap> queryScoreMan(HashMap map) {
        List<HashMap> list = statsMapper.queryScoreMan(map);
        return list;
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/5 10:44
    * @param
    * @Description 查询老师评价高于平均分的老师
    */
    @Override
    public List<HashMap> queryAverageTeacherDayu(HashMap map) {
        List<HashMap> list = statsMapper.queryAverageTeacherDayu(map);
        return list;
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/5 10:44
    * @param
    * @Description queryPie
    */
    @Override
    public List<HashMap> queryPie(HashMap map) {
        List<HashMap> listA = statsMapper.queryTeacherDaYu90(map);
        List<HashMap> listB = statsMapper.queryTeacherDaYu60XiaoYu90(map);
        List<HashMap> listC = statsMapper.queryTeacherXiaoyu60(map);
        List<HashMap> list = new ArrayList<HashMap>();
        HashMap map1 = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map1.put("size",listA.size());
        map1.put("name","优秀");
        map2.put("size",listB.size());
        map2.put("name","中等");
        map3.put("name","良好");
        map3.put("size",listC.size());
        list.add(map1);
        list.add(map2);
        list.add(map3);
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
    @Override
    public List<HashMap> queryBatchsList(HashMap map) {
        return statsMapper.queryBatchsList(map);
    }
   /**
   * @Author xiaoyi
   * @Return
   * @Date 2019/10/10 9:59
   * @param
   * @Description  二级联动查询问卷
   */
    @Override
    public List<HashMap> queryPapersList(HashMap map) {
        return statsMapper.queryPapersList(map);
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/10 14:56
    * @param
    * @Description 取评教成绩前5
    */
    @Override
    public List<HashMap> querySocoreLimit5(HashMap map) {
        return statsMapper.querySocoreLimit5(map);
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/10 16:44
    * @param
    * @Description 查询成绩
    */
    @Override
    public List<HashMap> querySocore(HashMap map) {
        return statsMapper.querySocore(map);
    }

    @Override
    public List<HashMap> queryScoreSize(HashMap map) {
        return statsMapper.queryScoreSize(map);
    }
}

