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
}
