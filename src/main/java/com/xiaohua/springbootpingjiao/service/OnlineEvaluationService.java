package com.xiaohua.springbootpingjiao.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/9/26 10:55
 * @VERSION: 1.0
 **/
public interface OnlineEvaluationService {
    List<Map<String, Object>> selectOnlineEvaluation(int papers_id);
}
