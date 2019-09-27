package com.xiaohua.springbootpingjiao.service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/25 23:26
 * @VERSION: 1.0
 **/
public interface ColleagueEvaluationService {
    List<HashMap> selectColleagueEvaluation(int user_id);
    List<HashMap> selectBatchIdColleagueEvaluation(int user_id,int batch_id);
}
