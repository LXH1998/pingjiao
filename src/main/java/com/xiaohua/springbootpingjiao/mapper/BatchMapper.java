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
}
