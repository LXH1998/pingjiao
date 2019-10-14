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
     * 查询是否有批次已开启
     */
    @ResponseBody
    @RequestMapping("/selectBatchHide")
    public Map selectBatchHide(){
        Map result = new HashMap();
        result.put("message","批次未开启");
        int count = targetService.selectBatchHide();
        if (count!=0){
            result.put("message","批次已开启");
        }
        return result;
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
        List<Integer> theList = new ArrayList<>();
        theList.add(target_Id);
        List<Integer> treeList = getTreeList(theList,target_Id);
        int count=0;
        for (Integer targetId:treeList){
            List<Integer> list = targetService.selectAllDeletedOptions(targetId);
            if (list.size()==0){
                targetService.deleteTarget(targetId);
                count +=1;
            }else {
                targetService.deleteAllOptions(list);
                targetService.deleteTargetOptions(targetId);
                targetService.deleteTarget(targetId);
                count +=1;
            }

        }
        if (count == treeList.size()){
                result.put("message","操作成功");
            }


//        result.put("message","操作失败");
//        List<Integer> sublevelList = targetService.isExitSublevel(target_Id);
//        List<Integer> list = targetService.selectAllDeletedOptions(target_Id);
//            targetService.deleteAllOptions(list);
//            int count = targetService.deleteTarget(target_Id);
//            if (count!=0){
//                result.put("message","操作成功");
//            }

        return result;
    }

    public List<Integer> getTreeList(List<Integer> theList, int target_Id){
//        List<Integer> treeList = new ArrayList<>();
        List<Integer> nextList = targetService.isExitSublevel(target_Id);
        for (Integer list:nextList){
            theList.add(list);
            getTreeList(theList,list);
        }
        return theList;
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
            int categoryCount = targetService.selectSubordinateTargetOption(target_Name,target_Id);
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

    /**
     * 修改选项 触发保存按钮
     */
    @ResponseBody
    @RequestMapping("/saveOptionsChange")
    public Map saveOptionsChange(String idList,String optionList,String weightList,int target_Id){
        Map result = new HashMap();
        result.put("message","操作失败");

        if (optionList.equals("未添加选项")&&weightList.equals("未添加选项")){
            int optionsCount = targetService.selectTheTargetOptions(target_Id);
            if (optionsCount==0){
                result.put("message","操作成功");
            }else {
                int deleteCount = targetService.deleteTheTargetOptions(target_Id);
                if (deleteCount!=0){
                    result.put("message","操作成功");
                }
            }
        }else {
            Options options = new Options();
            String optionsContentList[]=optionList.split(",");
            String optionsWeightList[]=weightList.split(",");
            int test = targetService.deleteTheTargetOptions(target_Id);
            int insertCount=0;
            if (idList.equals("")){
                List<Integer> list = targetService.selectAllDeletedOptions(target_Id);
                if (list.size()==0){
                    for (int i=0;i<optionsContentList.length;i++) {
                        String optionContent = optionsContentList[i];
                        Float optionWeight = Float.parseFloat(optionsWeightList[i]);
                        int addCount = targetService.insertOptions(optionContent,optionWeight,options);
                        if (addCount==1){
                            int insertOptionId = options.getOptions_Id();
                            int count1 = targetService.insertTargetOptions(target_Id, insertOptionId);
                            if (count1==1){
                                insertCount +=1;
                            }
                        }
                    }
                }else {
                    for (int i=0;i<optionsContentList.length;i++){
                        String optionContent = optionsContentList[i];
                        Float optionWeight = Float.parseFloat(optionsWeightList[i]);
                        int isUpdate = 0;
                        for (Integer theOptionsIdlist:list){
                            int sameContent = targetService.selectTheSameOption(theOptionsIdlist,optionContent);
                            if (sameContent==1){
                                int updataCount = targetService.updataOptionsContent(optionContent,optionWeight,theOptionsIdlist);
                                if (updataCount==1){
                                    int restoreCount = targetService.restoreTheTargetOptions(target_Id,theOptionsIdlist);
                                    if (restoreCount==1){
                                        insertCount +=1;
                                        isUpdate +=1;
                                        break;
                                    }
                                }
                            }
                        }
                        if (isUpdate==0){
                            int addCount = targetService.insertOptions(optionContent,optionWeight,options);
                            if (addCount==1){
                                int insertOptionId = options.getOptions_Id();
                                int count1 = targetService.insertTargetOptions(target_Id, insertOptionId);
                                if (count1==1){
                                    insertCount +=1;
                                }
                            }
                        }
//                    Float optionWeight = Float.parseFloat(optionsWeightList[i]);
//                    int count = targetService.insertOptions(optionContent,optionWeight,options);
//                    if (count==1){
//                        int insertOptionId = options.getOptions_Id();
//                        int count1 = targetService.insertTargetOptions(target_Id, insertOptionId);
//                        if (count1==1){
//                            insertCount +=1;
//                        }
//                    }
                    }
                }
                if (insertCount==optionsContentList.length){
                    result.put("message","操作成功");
                }
            }else {
                String optionsIdList[] = idList.split(",");
                int updateCount=0;

                for (int i=0;i<optionsIdList.length;i++){
                    String optionContent = optionsContentList[i];
                    Float optionWeight = Float.parseFloat(optionsWeightList[i]);
                    int optionId = Integer.parseInt(optionsIdList[i]);
                    int count = targetService.updataOptionsContent(optionContent,optionWeight,optionId);
                    if (count==1){
                        targetService.restoreTheTargetOptions(target_Id,optionId);
                        updateCount +=1;
                    }
                }
                if (updateCount==optionsIdList.length){
                    for (int i=updateCount;i<optionsContentList.length;i++){
                        String optionContent = optionsContentList[i];
                        Float optionWeight = Float.parseFloat(optionsWeightList[i]);
                        int count = targetService.insertOptions(optionContent,optionWeight,options);
                        if (count==1){
                            int insertOptionId = options.getOptions_Id();
                            int count1 = targetService.insertTargetOptions(target_Id, insertOptionId);
                            if (count1==1){
                                insertCount +=1;
                            }
                        }
                    }
                }
                if (insertCount==(optionsContentList.length-updateCount)){
                    result.put("message","操作成功");
                }
            }

        }
//        }
        return result;
    }
}
