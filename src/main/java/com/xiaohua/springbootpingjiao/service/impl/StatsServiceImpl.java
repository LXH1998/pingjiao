package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Fraction;
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
                    double stuSize = 1;
                    double teaSize = 1;
                    if (listStudent.size() != 0){
                        stuSize = listStudent.size();
                    }

                    for(WaterPojo demo:listStudent){
                        studentFraction = studentFraction + demo.getFractions();
                    }
                    List<WaterPojo> listTeacher  = listA.stream().filter(o -> o.getRole_name().equals("教师")).collect(Collectors.toList());
                    if (listTeacher.size() != 0){
                        teaSize = listTeacher.size();
                    }
                    for(WaterPojo demo:listTeacher){
                        teacherFraction = teacherFraction + demo.getFractions();
                    }
                    int f = list.size();
                    num = (studentFraction*0.4/stuSize+teacherFraction*0.6/teaSize);
                    Scores scores = new Scores();
                    Object teacherId = map.get("gradeds");
                    scores.setGradeds_Id(Integer.parseInt(teacherId.toString()));
                    scores.setPapers_id(papersId);
                    scores.setStudents_sum((studentFraction*0.4)/stuSize);
                    scores.setTeahcer_sum((teacherFraction*0.6)/teaSize);
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

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/12 9:17
    * @param
    * @Description 查询某老师 课程成绩
    */
    @Override
    public List<HashMap> queryTeacherScore(HashMap map) {
        List<HashMap> res = new ArrayList<HashMap>();
        List<HashMap> list = statsMapper.queryTeacherScore(map);
        List<HashMap> courseList = statsMapper.queryTeacherScoreList(map);
        String teacherName= list.get(0).get("user_name").toString();
        String teacherID= list.get(0).get("user_id").toString();
        String paperId= list.get(0).get("papers_id").toString();
        String couresName = null;
        String couresNID = null;
        for (HashMap coursID :courseList){
            double studentFraction = 0.0;
            double teacherFraction = 0.0;
            double stuSize = 1;
            double teaSize = 1;
            List<HashMap> listCourse  = list.stream().filter(o -> o.get("courses_id").equals(coursID.get("courses_id"))).collect(Collectors.toList());
                couresName = listCourse.get(0).get("courses_name").toString();
                couresNID =   listCourse.get(0).get("courses_id").toString();
                List<HashMap>  listStudent =listCourse.stream().filter(o -> o.get("role_name").equals("学生")).collect(Collectors.toList());
                if (listStudent.size() != 0){
                    stuSize = listStudent.size();
                }

                for(HashMap demo:listStudent){
                    studentFraction = studentFraction + Double.parseDouble(demo.get("fractions").toString());
                }
                List<HashMap>  listTeacher =listCourse.stream().filter(o -> o.get("role_name").equals("教师")).collect(Collectors.toList());
                if (listTeacher.size() != 0){
                    teaSize = listTeacher.size();
                }
                for(HashMap demo:listTeacher){

                    teacherFraction = teacherFraction + Double.parseDouble(demo.get("fractions").toString());
                }
            HashMap map1 = new HashMap();
            double score  = studentFraction*0.4/stuSize+teacherFraction*0.6/teaSize;
            map1.put("studentScore",(double) Math.round(studentFraction/stuSize * 100) / 100);
            map1.put("teacherScore",(double) Math.round(teacherFraction/teaSize * 100) / 100);
            map1.put("score",(double) Math.round(score * 100) / 100);
            map1.put("teacherID",teacherID);
            map1.put("teacherName",teacherName);
            map1.put("couresName",couresName);
            map1.put("couresID",couresNID);
            map1.put("paperId",paperId);
            res.add(map1);
            teacherFraction = 0.0;
            studentFraction = 0.0;

        }
        return res;
    }

    @Override
    public List<HashMap> queryTeacherScoreSize(HashMap map) {
        return statsMapper.queryTeacherScoreSize(map);
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/10/12 11:54
    * @param
    * @Description 查询被评分人具体评教详情
    */
    @Override
    public List<HashMap> querydetail(HashMap map) {
        return statsMapper.querydetail(map);
    }

    @Override
    public List<HashMap> querydetailSize(HashMap map) {
        return statsMapper.querydetailSize(map);
    }
    @Override
    public List<Fraction> selectEvaluationAnswers(int rater, int gradeds, int papers_id, int courses_id) {
        return statsMapper.selectEvaluationAnswers(rater, gradeds, papers_id, courses_id);
    }

    @Override
    public List<HashMap> selectFractions(int rater, int gradeds, int papers_id, int courses_id) {
        return statsMapper.selectFractions(rater, gradeds, papers_id, courses_id);
    }

    @Override
    public List<HashMap> queryBaticNameList(String batch_id) {
        return statsMapper.queryBaticNameList(batch_id);
    }
}

