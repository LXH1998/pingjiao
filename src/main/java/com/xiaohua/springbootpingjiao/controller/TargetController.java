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
//

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
//            result.put("isParent","false");
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

    /**
     * 添加下级指标类别
     */
    @ResponseBody
    @RequestMapping("/insertSubordinateTargetCategory")
    public Map insertSubordinateTargetCategory(String target_Name, Float target_Weight, int target_Id){
        Map result = new HashMap();
        int categoryCount = targetService.selectSubordinateTargetCategory(target_Name,target_Id);
        if (categoryCount==0){
            int count = targetService.insertSubordinateTargetCategory(target_Name,target_Weight,target_Id);
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
     * 添加指标(同时添加选项)
     */
    @ResponseBody
    @RequestMapping("/addTarget")
    public Map addTarget(String target_Name,Float target_Weight,String optionList,String weightList,int target_Id){
        Map result = new HashMap();
        if (optionList.equals("未添加选项")&&weightList.equals("未添加选项")){
            int categoryCount = targetService.selectSubordinateTargetCategory(target_Name,target_Id);
            if (categoryCount==0){
                Target target = new Target();
                int insertTargetCount = targetService.insertTarget(target_Name, target_Weight, target_Id, target);
                if (insertTargetCount==1){
                    result.put("message","操作成功");
                }
            }else {
                result.put("message","此类别已拥有该指标");
            }
        }else {
            int insertTargetId;
//        ArrayList insertOptionsId = new ArrayList();
            String optionsContent[]=optionList.split(",");
            String optionsWeight[]=weightList.split(",");
            Options options = new Options();

//        result.put("数据",insertOptionsId);
            int categoryCount = targetService.selectSubordinateTargetCategory(target_Name,target_Id);
            if (categoryCount==0) {
                Target target = new Target();
                int insertTargetCount = targetService.insertTarget(target_Name, target_Weight, target_Id, target);
                insertTargetId = target.getTarget_Id();
                int insertOptionsCount =0;
                int insertTargetOptionCount = 0;
                for (int i=0;i<optionsContent.length;i++){
                    String options_Content = optionsContent[i];
                    Float options_Weight = Float.parseFloat(optionsWeight[i]);
                    int count = targetService.insertOptions(options_Content,options_Weight,options);
                    if (count==1){
                        insertOptionsCount +=1;
                        int insertOptionId = options.getOptions_Id();
                        int count1 =targetService.insertTargetOptions(insertTargetId, insertOptionId);
                        if (count1 == 1){
                            insertTargetOptionCount +=1;
                        }

                    }
                }
                if (insertTargetCount==1&&insertOptionsCount==optionsContent.length&&insertTargetOptionCount==optionsContent.length){
                    result.put("message","操作成功");
                }
            }else {
                result.put("message","此类别已拥有该指标");
            }
        }

        return result;
    }


    /**
     * 保存--修改后的指标和权重
     */
    @ResponseBody
    @RequestMapping("/saveTargetCategoryChange")
    public Map saveTargetCategoryChange(String targetName,Float targetWeight, int targetId){
        Map result = new HashMap();
        int count = targetService.saveTargetCategoryChange(targetName,targetWeight,targetId);
        if (count==1){
            result.put("message","操作成功");
        }else {
            result.put("message","操作失败");
        }

        return result;
    }
}
