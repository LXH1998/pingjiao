package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.WaterPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StatsService {
    /**整理流水表信息*/
    List<WaterPojo> clearUpFraction(String batchId,String papersId);
    /**统计平价*/
    int statisticalFraction(List<WaterPojo> list,String batchId,String papers_Id);
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
    /**模糊查询院系平均分*/
    List<HashMap> queryDepartmentLike(HashMap map);

    List<HashMap> queryBatch();
    List<HashMap> queryPaper();
    List<HashMap> queryScoreDealits(HashMap map);
}
