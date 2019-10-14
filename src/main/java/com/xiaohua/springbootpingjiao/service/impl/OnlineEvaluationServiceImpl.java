package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.FractionSum;
import com.xiaohua.springbootpingjiao.entity.TargetOptins;
import com.xiaohua.springbootpingjiao.mapper.OnlineEvaluationMapper;
import com.xiaohua.springbootpingjiao.service.OnlineEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: luquanlin
 * @Date: 2019/9/26 10:55
 * @VERSION: 1.0
 **/

@Service
public class OnlineEvaluationServiceImpl implements OnlineEvaluationService {
    @Autowired
    private OnlineEvaluationMapper onlineEvaluationMapper;

    @Override
    public List<Map<String, Object>> selectOnlineEvaluation(int papers_id) {
        List<TargetOptins> list = onlineEvaluationMapper.selectOnlineEvaluation(papers_id);
        Map<Integer, List<TargetOptins>> map = list.stream().collect(Collectors.groupingBy(TargetOptins::getTarget_Id));
        List<Map<String, Object>> ret = new LinkedList<Map<String, Object>>();
        map.forEach( (k,v)->{
            Map<String, Object> tmap = new LinkedHashMap<>();
            tmap.put("target_id", k);

            List<Map<String, Object>> optionList = new LinkedList<>();
            v.stream().forEach(item->{
                Map<String, Object> omap = new LinkedHashMap<>();
                tmap.put("target_name", item.getTarget_Name());
                tmap.put("target_weight", item.getTarget_Weight());

                omap.put("options_id", item.getOptions_Id());
                omap.put("options_content", item.getOptions_Content());
                omap.put("options_weight", item.getOptions_Weight());
                optionList.add(omap);
            });
            tmap.put("options", optionList);

            ret.add(tmap);
        });

        return ret;
    }

    @Override
    public List<Map<String, Object>> selectHistoryOnlineEvaluation(int papers_id) {
        List<TargetOptins> list = onlineEvaluationMapper.selectHistoryOnlineEvaluation(papers_id);
        Map<Integer, List<TargetOptins>> map = list.stream().collect(Collectors.groupingBy(TargetOptins::getTarget_Id));
        List<Map<String, Object>> ret = new LinkedList<Map<String, Object>>();
        map.forEach( (k,v)->{
            Map<String, Object> tmap = new LinkedHashMap<>();
            tmap.put("target_id", k);

            List<Map<String, Object>> optionList = new LinkedList<>();
            v.stream().forEach(item->{
                Map<String, Object> omap = new LinkedHashMap<>();
                tmap.put("target_name", item.getTarget_Name());
                tmap.put("target_weight", item.getTarget_Weight());

                omap.put("options_id", item.getOptions_Id());
                omap.put("options_content", item.getOptions_Content());
                omap.put("options_weight", item.getOptions_Weight());
                optionList.add(omap);
            });
            tmap.put("options", optionList);

            ret.add(tmap);
        });

        return ret;
    }

    @Override
    public List<FractionSum> OnlineEvaluationFraction(int options_id,int target_id,int papers_id) {
        return onlineEvaluationMapper.OnlineEvaluationFraction(options_id,target_id,papers_id);
    }

    @Override
    public Boolean insertOnlineEvaluation(int rater, int gradeds, int papers_id, int courses_id, String answers, String fractions) {
        int userResult = onlineEvaluationMapper.insertOnlineEvaluation(rater, gradeds, papers_id, courses_id, answers, fractions);
        if(userResult > 0){
            return true;
        }
        return false;
    }

}

