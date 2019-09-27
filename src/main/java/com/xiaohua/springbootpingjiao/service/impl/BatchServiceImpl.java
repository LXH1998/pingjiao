package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.mapper.BatchMapper;
import com.xiaohua.springbootpingjiao.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author langxiaohua
 * @version 1.0
 * @date 2019/9/26 0026 10:05
 */
@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchMapper batchMapper;
    //查找所有批次
    @Override
    public List<Batch> SelectBatch(int pages,int limit) {
        return batchMapper.SelectBatch(pages,limit);
    }
    //查找批次数量
    @Override
    public int SelectBatchCount() {
        return batchMapper.SelectBatchCount();
    }

}
