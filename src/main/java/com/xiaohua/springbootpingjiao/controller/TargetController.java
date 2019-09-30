package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Options;
import com.xiaohua.springbootpingjiao.entity.Target;
import com.xiaohua.springbootpingjiao.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TargetController
 *
 * @author zuojie
 * @version 1.0
 * @Date 2019/9/25 0025
 * @Time 8:51
 **/
@Controller
@RequestMapping("/TargetManagement")
public class TargetController {

    @Autowired
    private TargetService targetService;

//    跳转指标管理选项卡
    @RequestMapping("/toIndex")
    public String toTargetManagement(){
        return "admin/target/target_test";
    }


    /**
     * 以树的形式显示指标
     * @return
     */
    @ResponseBody
    @RequestMapping("/targetTree")
    public List targetTree(){
        List<Map<String,Object>> list = new ArrayList<>();

        List<Target> targets = targetService.selectAllTarget();
        for (Target t:targets){
            Map result = new HashMap();

            result.put("id",t.getTarget_Id());
            result.put("pId",t.getParent_Id());
//            树 显示指标名和权重
            result.put("name",t.getTarget_Name() + "(" + t.getTarget_Weight() + ")");
            result.put("leafs",t.getLeafs_Id());
            result.put("targetWeight",t.getTarget_Weight());
            result.put("targetName",t.getTarget_Name());
            list.add(result);
        }
        return list;
    }


    /**
     * 查询指定指标的选项
     */
    @ResponseBody
    @RequestMapping("/targetOptions")
    public Map selectTargetOptions(int target_id){
        Map result = new HashMap();
        List<Options> options = targetService.selectTargetOptions(target_id);
        result.put("options",options);
        return result;
    }


    /**
     * 插入指标类别
     */
    @ResponseBody
    @RequestMapping("/addTargetCategory")
    public Map insertTargetCategory(String target_Name,Float target_Weight){
        Map result = new HashMap();
        int categoryCount = targetService.selectTheTargetCategory(target_Name);
        if (categoryCount==0){
            int count = targetService.insertTargetCategory(target_Name,target_Weight);
            if (count!=0){
                result.put("message","操作成功");
            }else {
                result.put("message","操作失败");
            }
        }else {
            result.put("message","指标类别已存在");
        }

        return result;
    }

    /**
     * 删除指标
     */
    @ResponseBody
    @RequestMapping("/deleteTarget")
    public Map deleteTarget(int target_Id){
        Map result = new HashMap();
        int count = targetService.deleteTarget(target_Id);
        if (count==1){
            result.put("message","操作成功");
        }else {
            result.put("message","操作失败");
        }
        return result;
    }
}
