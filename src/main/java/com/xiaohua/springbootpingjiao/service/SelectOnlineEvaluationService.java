package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Fraction;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/7 16:46
 * @VERSION: 1.0
 **/
public interface SelectOnlineEvaluationService {
    List<Fraction> selectEvaluationAnswers(int rater, int gradeds, int papers_id, int courses_id);
}
