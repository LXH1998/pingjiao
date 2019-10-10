package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Departments;
import com.xiaohua.springbootpingjiao.entity.Scores;
import com.xiaohua.springbootpingjiao.entity.WaterPojo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StatsMapper
 * @author:xiaoyi
 * @date: 2019/9/29 10:12
 * @Description :
 */
@Repository
public interface StatsMapper {
    /**
     * @param map
     * @return 整理流水表信息
     */
    List<WaterPojo> clearUpFraction(HashMap map);
    List<HashMap> queryTeacherStats(HashMap map);
    /**
     * @param map
     * @return 查询评教老师评教的科目
     */
    List<HashMap> queryTeacherCourse(HashMap map);
    int insertBatchScore(List<Scores> list);
    /**
     * @param map
     * @return 统计参与评教学院
     */
    List<HashMap> queryScoreDepartment(HashMap map);
    List<HashMap> queryPapers(HashMap map);
    /**
     * @param map
     * @return 查询参与评教老师
     */
    List<HashMap> queryScoreTeacher(HashMap map);
    /**
     * @param map
     * @return 查询评价人数
     */
    List<HashMap> queryScoreMan(HashMap map);
    /**
     * @param map
     * @return 查询老师评价高于平均分的老师
     */
    List<HashMap> queryAverageTeacherDayu(HashMap map);

    /**
     *  生成 好坏饼图
     */
    List<HashMap> queryTeacherDaYu90(HashMap map);
    List<HashMap> queryTeacherDaYu60XiaoYu90(HashMap map);
    List<HashMap> queryTeacherXiaoyu60(HashMap map);

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
