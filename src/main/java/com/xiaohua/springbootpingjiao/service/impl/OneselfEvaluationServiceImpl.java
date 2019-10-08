package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.mapper.OneselfEvaluationMapper;
import com.xiaohua.springbootpingjiao.service.OneselfEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class OneselfEvaluationServiceImpl implements OneselfEvaluationService{
    @Autowired
    private OneselfEvaluationMapper oneselfEvaluationMapper;

    @Override
    public List<HashMap> selectBatchIdOneselfEvaluation(int user_id, int batch_id) {
        return oneselfEvaluationMapper.selectBatchIdOneselfEvaluation(user_id,batch_id);
    }

//    @Override
//    public List<Batch> selectBatchName() {
//        return oneselfEvaluationMapper.selectBatchName();
//    }

    @Override
    public List<HashMap> selectOneselfEvaluation(int user_id) {
        return oneselfEvaluationMapper.selectOneselfEvaluation(user_id);
    }

    @Override
    public List<HashMap> selectIfOneselfEvaluation(int rater, int gradeds, int papers_id, int courses_id) {
        return oneselfEvaluationMapper.selectIfOneselfEvaluation(rater, gradeds, papers_id, courses_id);
    }
}
