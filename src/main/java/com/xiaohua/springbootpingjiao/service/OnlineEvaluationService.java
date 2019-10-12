package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.FractionSum;

import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/9/26 10:55
 * @VERSION: 1.0
 **/
public interface OnlineEvaluationService {
    List<Map<String, Object>> selectOnlineEvaluation(int papers_id);
    List<Map<String, Object>> selectHistoryOnlineEvaluation(int papers_id);
    List<FractionSum> OnlineEvaluationFraction(int options_id,int target_id);
    Boolean insertOnlineEvaluation(int rater, int gradeds, int papers_id, int courses_id, String answers, String fractions);
}
