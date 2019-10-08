package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Options;
import com.xiaohua.springbootpingjiao.entity.Target;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TargetMapper
 *
 * @author zuojie
 * @version 1.0
 * @Date 2019/9/25 0025
 * @Time 8:52
 **/
@Repository
public interface TargetMapper {
//

//    查询所有指标
    List<Target> selectAllTarget();

//    查询指标的选项
    List<Options> selectTargetOptions(int target_id);

//    插入之前查询是否存在相同指标类别（hides=1）
    int selectTheTargetCategory(String target_Name);
//    插入指标类别
    int insertTargetCategory(String target_Name,Float target_Weight);

//    删除指标
    int deleteTarget(int target_Id);

//    插入下级指标类别（查看当前指标类别下是否存在相同下级指标类别）
    int selectSubordinateTargetCategory(String target_Name, int target_Id);
//    插入下级指标类别
    int insertSubordinateTargetCategory(String target_Name,Float target_Weight,int target_Id);

//    插入指标
    int insertTarget(String target_Name,Float target_Weight,int target_Id,Target target);

//    插入选项
    int insertOptions(String options_Content, Float options_Weight, Options options);

//    指标和选项插入中间表
    int insertTargetOptions(int target_Id, int options_Id);

//    保存--修改后的指标内容和权重
    int saveTargetCategoryChange(String targetName,Float targetWeight, int targetId);
}
