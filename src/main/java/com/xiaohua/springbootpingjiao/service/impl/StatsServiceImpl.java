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
    public List<WaterPojo> clearUpFraction(String batchId,String papersId) {
        HashMap map = new HashMap();
        map.put("batchId",batchId);
        map.put("papersId",papersId);
        List<WaterPojo> list = statsMapper.clearUpFraction(map);
        int result = statisticalFraction(list,batchId,papersId);
        System.out.println("1234    ");
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
    public int statisticalFraction(List<WaterPojo> list,String batchId,String papers_Id) {
        HashMap mapOne = new HashMap();
        mapOne.put("batchId",batchId);
        mapOne.put("papersId",papers_Id);
        List<HashMap> ID = statsMapper.queryTeacherStats(mapOne);
        double studentFraction = 0;
        double teacherFraction = 0;
        double num = 0;
        List<Scores> statisticalDemo = new ArrayList<Scores>();

        for (HashMap map : ID){
            Integer papersId = 0;
            List<WaterPojo> listA  = list.stream().filter(o -> o.getUser_id().equals(map.get("gradeds"))).collect(Collectors.toList());
            HashMap hashMap = new HashMap();
            papersId = Integer.parseInt(papers_Id);
            hashMap.put("batchId",batchId);
            hashMap.put("gradeds",map.get("gradeds"));
            hashMap.put("papersId",papersId);
            List<HashMap> coureseList  = statsMapper.queryTeacherCourse(hashMap);
            for (HashMap hashMap1 :coureseList){
                List<WaterPojo> listB  = listA.stream().filter(o -> o.getCourses_id().equals(hashMap1.get("courses_id"))).collect(Collectors.toList());
                List<WaterPojo> listStudent  = listB.stream().filter(o -> o.getRole_name().equals("学生")).collect(Collectors.toList());

                for(WaterPojo demo:listStudent){
                    studentFraction = studentFraction + demo.getFractions();
                }
                List<WaterPojo> listTeacher  = listB.stream().filter(o -> o.getRole_name().equals("教师")).collect(Collectors.toList());

                for(WaterPojo demo:listTeacher){
                    teacherFraction = teacherFraction + demo.getFractions();
                }

                int f = list.size();
                num = (studentFraction*0.3+teacherFraction*0.7);
                Scores scores = new Scores();
                Object teacherId = map.get("gradeds");
                scores.setScores_Id(Integer.parseInt(hashMap1.get("courses_id").toString()));
                scores.setGradeds_Id(Integer.parseInt(teacherId.toString()));
                scores.setPapers_id(papersId);
                scores.setBatch_id(Integer.parseInt(batchId));
                scores.setScores_Sum(String.valueOf(num));
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
    * @Date 2019/10/5 10:47
    * @param
    * @Description 模糊查询院系平均分
    */
    @Override
    public List<HashMap> queryDepartmentLike(HashMap map) {
        String  batchId = "0";
        String papersId = "0";
        List<HashMap> list = statsMapper.queryDepartmentLike(map);
        if (map.containsKey("batchId")){
              batchId = map.get("batchId").toString();
        }
        if (map.containsKey("papersId")){
            papersId = map.get("papersId").toString();
        }
        List<HashMap> result = new ArrayList();
        double avg = 0.0;
        double sum = 0.0;
        int size = 1;
        List<HashMap> lsitDpartmentName = statsMapper.queryScoreDepartment(map);
        if(batchId == "0"){
            if(papersId != "0"){
               List<HashMap> listBatchId = statsMapper.queryBatchIdLike(map);
                List<HashMap> list1  = new ArrayList<>();
               for(HashMap map1 : listBatchId){
                   List<HashMap> res = new ArrayList<HashMap>();
                   List<HashMap> listA  = list.stream().filter(o -> o.get("batch_id").equals(map1.get("batch_id"))).collect(Collectors.toList());
                   for (HashMap map2 : lsitDpartmentName){
                       List<HashMap> listB = listA.stream().filter(o -> o.get("departments_name").equals(map2.get("departments_name"))).collect(Collectors.toList());
                       for (HashMap map3 : listB){
                           sum = sum +Double.parseDouble(map3.get("scores_sum").toString());
                           size = size+ 1;
                       }
                       HashMap map3 = new HashMap();
                       if (size== 0){
                           avg = 0;
                       }else {
                           avg = sum/size;
                       }
                       map3.put("avg",avg);
                       map3.put("departmentName",map2.get("departments_name"));
                       map3.put("batch_id", map1.get("batch_id"));
                       map3.put("paperId", papersId);
                       res.add(map3);
                       avg = 0 ;
                       sum = 0 ;
                       size = 0;
                   }
                   HashMap demo = new HashMap();
                   demo.put("batch_id",map1.get("batch_id"));
                   demo.put("batch_idList",res);
                   list1.add(demo);
               }
                HashMap mapt = new HashMap();
                mapt.put("paperId",papersId);
                mapt.put("paperList",list1);
                mapt.put("type","试卷");
                List<HashMap> aa = statsMapper.queryDartpmentName();
                mapt.put("departmentName",aa);
                result.add(mapt);

                return  result;
            }
        }

        List<HashMap> listBatchId = statsMapper.queryBatchIdLike(map);
        List<HashMap> listPaperId = statsMapper.queryPaperIdLike(map);
        //TODO 修改
        if (batchId == "0"&&papersId == "0") {
            for(HashMap map1 : listBatchId) {
                List<HashMap> listA = list.stream().filter(o -> o.get("batch_id").equals(map1.get("batch_id"))).collect(Collectors.toList());
                List<HashMap> list1  = new ArrayList<>();
                for (HashMap a1 : listPaperId) {
                    List<HashMap> listPaper = listA.stream().filter(o -> o.get("papers_id").equals(a1.get("papers_id"))).collect(Collectors.toList());
                    List<HashMap> res = new ArrayList<HashMap>();
                    for (HashMap map2 : lsitDpartmentName) {
                        List<HashMap> listB = listPaper.stream().filter(o -> o.get("departments_name").equals(map2.get("departments_name"))).collect(Collectors.toList());
                        for (HashMap map3 : listB) {
                            sum = sum + Double.parseDouble(map3.get("scores_sum").toString());
                            size = size + 1;
                        }
                        HashMap mm3 = new HashMap();
                        if (size== 0){
                            avg = 0;
                        }else {
                            avg = sum/size;
                        }
                        mm3.put("avg", avg);
                        mm3.put("departmentName", map2.get("departments_name"));
                        mm3.put("paperId", a1.get("papers_id"));
                        mm3.put("batch_id", map1.get("batch_id"));
                        res.add(mm3);
                        avg = 0;
                        sum = 0;
                        size = 0;
                    }
                    HashMap demo = new HashMap();
                    demo.put("papers_id",a1.get("papers_id"));
                    demo.put("paperList",res);
                    list1.add(demo);
                }
                HashMap mapt = new HashMap();
                mapt.put("batch_id",map1.get("batch_id"));
                mapt.put("type","问卷为空,试卷为空");
                mapt.put("batchList",list1);
                List<HashMap> aa = statsMapper.queryDartpmentName();
                mapt.put("departmentName",aa);
                result.add(mapt);
            }
            return result;
        }

        List<HashMap> list1  = new ArrayList<>();
        for (HashMap a1 : listPaperId) {
            List<HashMap> listPaper = list.stream().filter(o -> o.get("papers_id").equals(a1.get("papers_id"))).collect(Collectors.toList());
            List<HashMap> res = new ArrayList<HashMap>();
            for (HashMap map2 : lsitDpartmentName) {
                List<HashMap> listB = listPaper.stream().filter(o -> o.get("departments_name").equals(map2.get("departments_name"))).collect(Collectors.toList());
                for (HashMap map3 : listB) {
                    sum = sum + Double.parseDouble(map3.get("scores_sum").toString());
                    size = size + 1;
                }
                HashMap mm3 = new HashMap();
                if (size== 0){
                    avg = 0;
                }else {
                    avg = sum/size;
                }
                mm3.put("avg", avg);
                mm3.put("departmentName", map2.get("departments_name"));
                mm3.put("paperId", a1.get("papers_id"));
                mm3.put("batch_id", batchId);
                res.add(mm3);
                avg = 0;
                sum = 0;
                size = 0;
            }
            HashMap demo = new HashMap();
            demo.put("papers_id",a1.get("papers_id"));
            demo.put("paperList",res);
            list1.add(demo);
        }
        HashMap mapt = new HashMap();
        mapt.put("batch_id",batchId);
        mapt.put("type","问卷");
        mapt.put("batchList",list1);
        List<HashMap> aa = statsMapper.queryDartpmentName();
        mapt.put("departmentName",aa);
        result.add(mapt);
        return result;
    }

    @Override
    public List<HashMap> queryBatch() {
        return statsMapper.queryBatch();
    }

    @Override
    public List<HashMap> queryPaper() {
        return statsMapper.queryPaper();
    }

    @Override
    public List<HashMap> queryScoreDealits(HashMap map) {
        return statsMapper.queryScoreDealits(map);
    }
}

