package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.mapper.BatchMapper;
import com.xiaohua.springbootpingjiao.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

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

    //增加批次
    @Override
    public int InsertBatch(String batch_Name) {
        return batchMapper.InsertBatch(batch_Name);
    }
    //模糊查找批次
    @Override
    public List<Batch> SelectBatchName(String batch_Name, int pages, int limit) {
        return batchMapper.SelectBatchName(batch_Name,pages,limit);
    }

    @Override
    public int SelectBatchNameCount(String batch_Name) {
        return batchMapper.SelectBatchNameCount(batch_Name);
    }
    //精确查找某批次是否存在
    @Override
    public int SelectBatchOne(String batch_Name) {
        return batchMapper.SelectBatchOne(batch_Name);
    }
    //修改批次状态为开启
    @Override
    public int ModifyOpenBatch(int batch_Id) {
        return batchMapper.ModifyOpenBatch(batch_Id);
    }
    //修改批次状态为暂停
    @Override
    public int ModifySuspendBatch(int batch_Id) {
        return batchMapper.ModifySuspendBatch(batch_Id);
    }
    //修改批次状态为结束
    @Override
    public int ModifyEndBatch(int batch_Id) {
        return batchMapper.ModifyEndBatch(batch_Id);
    }
    //删除某个批次
    @Override
    public int DeleteOneBatch(int batch_Id) {
        return batchMapper.DeleteOneBatch(batch_Id);
    }
    //是否有批次正在开启
    @Override
    public String IfBatchOpen() {
        return batchMapper.IfBatchOpen();
    }

    //转移数据到历史表中  通过事务处理
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public int CopyTargetOptions(int papers_Id) {
        int tag = 1;
        try {
            batchMapper.CopyTarget(papers_Id,papers_Id);
            batchMapper.CopyOptions(papers_Id);
        }catch (Exception e){
            tag = 0;
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
//        batchMapper.CopyOptions(papers_Id);
        return tag;
    }

    @Override
    public  List<Map<String, Integer>>  SelectBatchPapers(int batch_Id) {
        List<Map<String, Integer>> batchPapers =  batchMapper.SelectBatchPapers(batch_Id);
        return batchPapers;
    }


}
