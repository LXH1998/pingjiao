package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Batch;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OneselfEvaluationMapper {
    List<HashMap> selectOneselfEvaluation(int user_id);
    List<Batch> selectBatchName();
    List<HashMap> selectBatchIdStudentEvaluation(int user_id,int batch_id);
}
