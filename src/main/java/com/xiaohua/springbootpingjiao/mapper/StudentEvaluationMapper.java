package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Batch;
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
    List<Batch> selectBatchName();
    List<HashMap> selectBatchIdStudentEvaluation(int user_id,int batch_id);
}
