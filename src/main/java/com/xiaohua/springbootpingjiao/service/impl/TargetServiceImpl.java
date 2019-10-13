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
//

    @Autowired
    private TargetMapper targetMapper;

//    查询是否有批次已开启
    @Override
    public int selectBatchHide() {
        return targetMapper.selectBatchHide();
    }

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

//    插入指标类别之前查询是否已存在该类别（hides=1）
    @Override
    public int selectTheTargetCategory(String target_Name) {
        return targetMapper.selectTheTargetCategory(target_Name);
    }
//    插入指标类别
    @Override
    public int insertTargetCategory(String target_Name, Float target_Weight) {
        return targetMapper.insertTargetCategory(target_Name,target_Weight);
    }

//    删除指标
    @Override
    public int deleteTarget(int target_Id) {
        return targetMapper.deleteTarget(target_Id);
    }

//    插入下级指标类别（查看当前指标类别下是否存在相同下级指标类别）
    @Override
    public int selectSubordinateTargetCategory(String target_Name, int target_Id) {
        return targetMapper.selectSubordinateTargetCategory(target_Name,target_Id);
    }
//    插入下级指标类别
    @Override
    public int insertSubordinateTargetCategory(String target_Name, Float target_Weight, int target_Id) {
        return targetMapper.insertSubordinateTargetCategory(target_Name,target_Weight,target_Id);
    }

    @Override
    public int insertTarget(String target_Name, Float target_Weight, int target_Id, Target target) {
//        return targetMapper.insertTarget(target_Name,target_Weight,target_Id);
        return targetMapper.insertTarget(target_Name,target_Weight,target_Id,target);
    }

    @Override
    public int insertOptions(String options_Content, Float options_Weight, Options options) {
        return targetMapper.insertOptions(options_Content,options_Weight,options);
    }

    @Override
    public int insertTargetOptions(int target_Id, int options_Id) {
        return targetMapper.insertTargetOptions(target_Id,options_Id);
    }

    @Override
    public int saveTargetCategoryChange(String targetName, Float targetWeight, int targetId) {
        return targetMapper.saveTargetCategoryChange(targetName,targetWeight,targetId);
    }

//    查询指标选项表中是否存在指定指标的选项
    @Override
    public int selectTheTargetOptions(int targetId) {
        return targetMapper.selectTheTargetOptions(targetId);
    }
    //    删除指标选项表中指定的选项
    @Override
    public int deleteTargetOptions(int targetId) {
        return targetMapper.deleteTargetOptions(targetId);
    }

    //    删除指定指标的选项
    @Override
    public int deleteTheTargetOptions(int targetId) {
        return targetMapper.deleteTheTargetOptions(targetId);
    }

    @Override
    public int restoreTheTargetOptions(int targetId,int optionId) {
        return targetMapper.restoreTheTargetOptions(targetId,optionId);
    }

    //    修改指定选项内容
    @Override
    public int updataOptionsContent(String optionContent, Float optionWeight, int optionId) {
        return targetMapper.updataOptionsContent(optionContent,optionWeight,optionId);
    }

    //    查询指定指标全部删除的选项
    @Override
    public List<Integer> selectAllDeletedOptions(int targetId) {
        return targetMapper.selectAllDeletedOptions(targetId);
    }

    @Override
    public int selectTheSameOption(int optionsId, String optionsContent) {
        return targetMapper.selectTheSameOption(optionsId,optionsContent);
    }

    @Override
    public int deleteAllOptions(List<Integer> list) {
        return targetMapper.deleteAllOptions(list);
    }

//    查询所有targetId
    @Override
    public List<Integer> isExitSublevel(int targetId) {
        return targetMapper.isExitSublevel(targetId);
    }


}
