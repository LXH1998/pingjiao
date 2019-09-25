package com.xiaohua.springbootpingjiao.service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/24 12:05
 * @VERSION: 1.0
 **/
public interface StudentEvaluationService {
    List<HashMap> selectStudentEvaluation(int user_id);
}
