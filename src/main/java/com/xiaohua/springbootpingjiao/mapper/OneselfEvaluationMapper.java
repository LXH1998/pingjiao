package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Batch;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OneselfEvaluationMapper {
    List<HashMap> selectOneselfEvaluation(int user_id);
//    List<Batch> selectBatchName();
    List<HashMap> selectBatchIdOneselfEvaluation(int user_id,int batch_id);
    List<HashMap> selectIfOneselfEvaluation(int rater,int gradeds,int papers_id,int courses_id);
}
