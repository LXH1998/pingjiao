package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Batch;
import com.xiaohua.springbootpingjiao.entity.Courses;
import com.xiaohua.springbootpingjiao.entity.TeachData;
import com.xiaohua.springbootpingjiao.entity.User;

import java.util.List;

public interface BatchMapper {

    //查找所有批次
     List<Batch> SelectBatch(int pages,int limit);
     //查找批次数量
    int SelectBatchCount();
    //模糊查找批次
    List<Batch> SelectBatchName(String batch_Name,int pages,int limit);
    //模糊查找批次的数量
    int SelectBatchNameCount(String batch_Name);
    //增加批次
    int InsertBatch(String batch_Name);
    //精确查找某批次是否存在
    int SelectBatchOne(String batch_Name);
}
