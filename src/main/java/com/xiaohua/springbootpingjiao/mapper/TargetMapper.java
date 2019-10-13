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

//    查询是否有批次已开启
    int selectBatchHide();

//    查询所有指标
    List<Target> selectAllTarget();

//    查询指标的选项
    List<Options> selectTargetOptions(int target_id);

//    插入之前查询是否存在相同指标类别（hides=1）
    int selectTheTargetCategory(String target_Name);
//    插入指标类别
    int insertTargetCategory(String target_Name,Float target_Weight);

//    删除指标选项表中指定的选项
    int deleteTargetOptions(int targetId);
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

//    查询指标选项表中是否存在指定指标的选项
    int selectTheTargetOptions(int targetId);

//    删除指定指标的选项
    int deleteTheTargetOptions(int targetId);

//    恢复指定指标选项
    int restoreTheTargetOptions(int targetId,int optionId);

//    修改指定选项内容
    int updataOptionsContent(String optionContent,Float optionWeight,int optionId);

//    查询指定指标全部删除的选项
    List<Integer> selectAllDeletedOptions(int targetId);

//
    int selectTheSameOption(int optionsId, String optionsContent);

//    删除指定指标的全部选项
    int deleteAllOptions(List<Integer> list);

//    查询所有targetId
    List<Integer> isExitSublevel(int targetId);
}
