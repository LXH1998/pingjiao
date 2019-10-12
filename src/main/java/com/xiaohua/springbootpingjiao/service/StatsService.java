package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.WaterPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StatsService {
    /**整理流水表信息*/
    List<WaterPojo> clearUpFraction(String batchId);
    /**统计平价*/
    int statisticalFraction(List<WaterPojo> list,String batchId);
    /**统计参与评教学院*/
    List<HashMap> queryScoreDepartment(HashMap map);
    /**查询参与评教老师*/
    List<HashMap> queryScoreTeacher(HashMap map);
    /**查询评价人数*/
    List<HashMap> queryScoreMan(HashMap map);
    /**查询老师评价高于平均分的老师*/
    List<HashMap> queryAverageTeacherDayu(HashMap map);
    /**好坏饼图*/
    List<HashMap> queryPie(HashMap map);
    /**
     *二级联动查询批次
     */
    List<HashMap> queryBatchsList(HashMap map);

    /**
     * 二级联动查询问卷
     */
    List<HashMap> queryPapersList(HashMap map);

    /***
     *取评教成绩前5
     */
    List<HashMap> querySocoreLimit5(HashMap map);
    /**
     * 查询成绩
     */
    List<HashMap> querySocore(HashMap map);
    List<HashMap> queryScoreSize(HashMap map);

}
