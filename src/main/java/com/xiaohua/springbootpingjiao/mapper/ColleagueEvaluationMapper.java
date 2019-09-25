package com.xiaohua.springbootpingjiao.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/25 23:25
 * @VERSION: 1.0
 **/

@Repository
public interface ColleagueEvaluationMapper {
    List<HashMap> selectColleagueEvaluation(int user_id);
}
