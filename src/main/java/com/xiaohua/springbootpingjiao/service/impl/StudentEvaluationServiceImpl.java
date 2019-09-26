package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.mapper.StudentEvaluationMapper;
import com.xiaohua.springbootpingjiao.service.StudentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/24 12:05
 * @VERSION: 1.0
 **/
@Service
public class StudentEvaluationServiceImpl implements StudentEvaluationService {
    @Autowired
    private StudentEvaluationMapper studentEvaluationMapper;

    @Override
    public List<HashMap> selectBatchIdStudentEvaluation(int user_id, int batch_id) {
        return studentEvaluationMapper.selectBatchIdStudentEvaluation(user_id,batch_id);
    }

    @Override
    public List<Batch> selectBatchName() {
        return studentEvaluationMapper.selectBatchName();
    }

    @Override
    public List<HashMap> selectStudentEvaluation(int user_id) {
        return studentEvaluationMapper.selectStudentEvaluation(user_id);
    }
}
