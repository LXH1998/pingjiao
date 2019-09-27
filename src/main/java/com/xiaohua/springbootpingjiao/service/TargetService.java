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

//    查询所有的指标
    List<Target> selectAllTarget();

//    查询指定指标的选项
    List<Options> selectTargetOptions(int target_id);
}
