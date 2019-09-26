package com.xiaohua.springbootpingjiao.service.impl;

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
}
