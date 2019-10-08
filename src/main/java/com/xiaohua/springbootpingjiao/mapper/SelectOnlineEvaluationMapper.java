package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Fraction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/7 16:46
 * @VERSION: 1.0
 **/
@Repository
public interface SelectOnlineEvaluationMapper {
    List<Fraction> selectEvaluationAnswers(int rater,int gradeds,int papers_id,int courses_id);
    List<HashMap> selectFractions(int rater,int gradeds,int papers_id,int courses_id);
}
