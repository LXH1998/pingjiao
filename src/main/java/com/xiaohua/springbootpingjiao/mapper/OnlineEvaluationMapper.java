package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.FractionSum;
import com.xiaohua.springbootpingjiao.entity.TargetOptins;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/26 10:54
 * @VERSION: 1.0
 **/

@Repository
public interface OnlineEvaluationMapper {
    List<TargetOptins> selectOnlineEvaluation(int papers_id);
    List<TargetOptins> selectHistoryOnlineEvaluation(int papers_id);
    List<FractionSum> OnlineEvaluationFraction(int options_id,int target_id,int papers_id);
    int insertOnlineEvaluation(int rater,int gradeds,int papers_id,int courses_id,String answers,String fractions);
}
