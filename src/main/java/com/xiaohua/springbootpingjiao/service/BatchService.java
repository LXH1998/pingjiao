package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface BatchService {
    //查找所有批次
    List<Batch> SelectBatch(int pages,int limit);
    //查找批次数量
    int SelectBatchCount();
    //增加批次
    int InsertBatch(String batch_Name);
    //模糊查找批次
    List<Batch> SelectBatchName(String batch_Name,int pages,int limit);
    //模糊查找批次的数量
    int SelectBatchNameCount(String batch_Name);
    //精确查找某批次是否存在
    int SelectBatchOne(String batch_Name);
    //修改批次状态为开启
    int ModifyOpenBatch(int batch_Id);
    //修改批次状态为暂停
    int ModifySuspendBatch(int batch_Id);
    //修改批次状态为结束
    int ModifyEndBatch(int batch_Id);
    //删除某个批次
    int DeleteOneBatch(int batch_Id);
    //判断是否有批次开启
    String IfBatchOpen();

}
