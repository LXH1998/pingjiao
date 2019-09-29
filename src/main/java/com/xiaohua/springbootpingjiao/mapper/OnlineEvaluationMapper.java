package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.TargetOptins;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/9/26 10:54
 * @VERSION: 1.0
 **/

@Repository
public interface OnlineEvaluationMapper {
    List<TargetOptins> selectOnlineEvaluation(int papers_id);
}
