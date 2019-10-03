package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Batch;

import java.util.HashMap;
import java.util.List;

public interface OneselfEvaluationService {
    List<HashMap> selectOneselfEvaluation(int user_id);
//    List<Batch> selectBatchName();
    List<HashMap> selectBatchIdOneselfEvaluation(int user_id,int batch_id);
}
