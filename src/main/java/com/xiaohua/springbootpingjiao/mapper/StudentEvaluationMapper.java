package com.xiaohua.springbootpingjiao.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/24 12:04
 * @VERSION: 1.0
 **/

@Repository
public interface StudentEvaluationMapper {
    List<HashMap> selectStudentEvaluation(int user_id);
}
