package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Options;
import com.xiaohua.springbootpingjiao.entity.Target;

import java.util.List;

/**
 * TargetService
 *
 * @author zuojie
 * @version 1.0
 * @Date 2019/9/25 0025
 * @Time 8:53
 **/
public interface TargetService {
//

//    查询所有的指标
    List<Target> selectAllTarget();

//    查询指定指标的选项
    List<Options> selectTargetOptions(int target_id);

//    插入指标类别之前查询是否已存在该类别(hides=1)
    int selectTheTargetCategory(String target_Name);
//    插入指标类别
    int insertTargetCategory(String target_Name,Float target_Weight);

//    删除指标
    int deleteTarget(int target_Id);
}
