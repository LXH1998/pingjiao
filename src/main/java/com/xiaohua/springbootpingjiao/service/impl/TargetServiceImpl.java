package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Options;
import com.xiaohua.springbootpingjiao.entity.Target;
import com.xiaohua.springbootpingjiao.mapper.TargetMapper;
import com.xiaohua.springbootpingjiao.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TargetServiceImpl
 *
 * @author zuojie
 * @version 1.0
 * @Date 2019/9/25 0025
 * @Time 8:53
 **/
@Service
public class TargetServiceImpl implements TargetService {

    @Autowired
    private TargetMapper targetMapper;

//    查询所有的指标
    @Override
    public List<Target> selectAllTarget() {
        return targetMapper.selectAllTarget();
    }

//    查询指定指标的选项
    @Override
    public List<Options> selectTargetOptions(int target_id) {
        return targetMapper.selectTargetOptions(target_id);
    }

    @Override
    public int insertTargetCategory(String target_Name, Float target_Weight) {
        return targetMapper.insertTargetCategory(target_Name,target_Weight);
    }
}
