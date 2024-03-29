package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.mapper.ColleagueEvaluationMapper;
import com.xiaohua.springbootpingjiao.service.ColleagueEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/25 23:26
 * @VERSION: 1.0
 **/
@Service
public class ColleagueEvaluationServiceImpl implements ColleagueEvaluationService {
    @Autowired
    private ColleagueEvaluationMapper colleagueEvaluationMapper;

    @Override
    public List<HashMap> selectBatchIdColleagueEvaluation(int user_id, int batch_id) {
        return colleagueEvaluationMapper.selectBatchIdColleagueEvaluation(user_id, batch_id);
    }

    @Override
    public List<HashMap> selectColleagueEvaluation(int user_id) {
        return colleagueEvaluationMapper.selectColleagueEvaluation(user_id);
    }

    @Override
    public List<HashMap> selectIfEvaluation(int rater, int gradeds, int papers_id, int courses_id) {
        return colleagueEvaluationMapper.selectIfEvaluation(rater, gradeds, papers_id, courses_id);
    }

    @Override
    public List<Batch> selectIfStartEvaluation(int batch_Id) {
        return colleagueEvaluationMapper.selectIfStartEvaluation(batch_Id);
    }
}
