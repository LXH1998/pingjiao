package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Batch;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/24 12:05
 * @VERSION: 1.0
 **/
public interface StudentEvaluationService {
    List<HashMap> selectStudentEvaluation(int user_id);
    List<Batch> selectBatchName();
    List<HashMap> selectBatchIdStudentEvaluation(int user_id,int batch_id);
}
