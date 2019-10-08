package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Fraction;
import com.xiaohua.springbootpingjiao.mapper.SelectOnlineEvaluationMapper;
import com.xiaohua.springbootpingjiao.service.SelectOnlineEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/7 16:46
 * @VERSION: 1.0
 **/

@Service
public class SelectOnlineEvaluationServiceImpl implements SelectOnlineEvaluationService {
    @Autowired
    private SelectOnlineEvaluationMapper selectOnlineEvaluationMapper;

    @Override
    public List<Fraction> selectEvaluationAnswers(int rater, int gradeds, int papers_id, int courses_id) {
        return selectOnlineEvaluationMapper.selectEvaluationAnswers(rater, gradeds, papers_id, courses_id);
    }

    @Override
    public List<HashMap> selectFractions(int rater, int gradeds, int papers_id, int courses_id) {
        return selectOnlineEvaluationMapper.selectFractions(rater, gradeds, papers_id, courses_id);
    }
}
