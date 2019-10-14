package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.*;
import com.xiaohua.springbootpingjiao.entity.Class;
import com.xiaohua.springbootpingjiao.service.BatchService;
import com.xiaohua.springbootpingjiao.service.ClassService;
import com.xiaohua.springbootpingjiao.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 批次处理层
 */
@Controller
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    BatchService batchService;
    @RequestMapping("/index")
    public String goBatch()
    {
        return "admin/batch/batch_index";
    }
    //查询批次
    @RequestMapping("/listDate")
    @ResponseBody
    public Map BatchListAll(int page,int limit){
        int pages = (page-1)*limit;
        List<Batch> batchList = batchService.SelectBatch(pages,limit);
        int count = batchService.SelectBatchCount();
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("count",count);
        result.put("data",batchList);
        return result;
    }

    //模糊查询批次
    @ResponseBody
    @RequestMapping("/SelectBatchName")
    public Map OneTeachListDate(String batch_Name,int page,int limit){
        int pages = (page-1)*limit;
        List<Batch> batchList = batchService.SelectBatchName(batch_Name,pages,limit);
        int count = batchService.SelectBatchNameCount(batch_Name);
        Map result = new HashMap<>();
        result.put("code",0);
        result.put("msg","返回成功");
        result.put("data",batchList);
        result.put("count",count);
        return result;
    }
    //增加批次
    @ResponseBody
    @RequestMapping("/insertBatch")
    public Map insertBatch(String batch_Name){
        int batchIf = batchService.SelectBatchOne(batch_Name);
        Map result = new HashMap();
        if (batchIf==0){
            int insertResult = batchService.InsertBatch(batch_Name);
            if (insertResult == 1){
                result.put("result","操作成功");
            }else {
                result.put("result","操作失败");
            }
        }else{
            result.put("result","当前批次已存在");
        }
        return result;
    }
    //修改批次状态为关闭
    @ResponseBody
    @RequestMapping("/modifyOpenBatch")
    public Map ModifyOpenBatch(int batch_Id)
    {
        int batchIf = batchService.ModifyOpenBatch(batch_Id);
        Map result = new HashMap();
        if(batchIf == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }
    //修改批次状态为暂停
    @ResponseBody
    @RequestMapping("/modifySuspendBatch")
    public Map ModifySuspendBatch(int batch_Id)
    {
        int batchIf = batchService.ModifySuspendBatch(batch_Id);
        Map result = new HashMap();
        if(batchIf == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }

    //修改批次状态为关闭
    @ResponseBody
    @RequestMapping("/modifyEndBatch")
    public Map ModifyEndBatch(int batch_Id)
    {
        int ifCopy = 1;
        Map result = new HashMap();
        //复制当前批次下的所有问卷表到历史表中
        List<Map<String, Integer>>  papers_Ids = batchService.SelectBatchPapers(batch_Id);
        for(Map<String, Integer> paper:papers_Ids)
        {
            int papers_id =  paper.get("papers_id");
            if(batchService.CopyTargetOptions(papers_id) == 0)
            {
                ifCopy = 0;
                break;
            }
            System.out.println(papers_id);
        }
        if(ifCopy == 1)
        {
            int batchIf = batchService.ModifyEndBatch(batch_Id);;//修改状态量
            if(batchIf == 1){
                result.put("result","1");
            }else {
                result.put("result","2");
            }
        }else {
            result.put("result","0");//未复制成功
        }
        return result;
    }
    //删除某个批次
    @ResponseBody
    @RequestMapping("/deleteOneBatch")
    public Map DeleteOneBatch(int batch_Id)
    {
        int batchIf = batchService.DeleteOneBatch(batch_Id);
        Map result = new HashMap();
        if(batchIf == 1){
            result.put("result","操作成功");
        }else {
            result.put("result","操作失败");
        }
        return result;
    }
    //判断是否有批次是开启状态
    @ResponseBody
    @RequestMapping("/ifOpen")
    public Map IfBatchOpen()
    {
        String ifOpen = batchService.IfBatchOpen();
        Map result = new HashMap();
        if(!ifOpen.equals("0"))
        {
            result.put("result","1");
        }else {
            result.put("result","0");
        }

        return  result;
    }

//    @ResponseBody
//    @RequestMapping("/batch_papers")
//    public  List<Map<String, Integer>> CopyTargetOptions(int batch_Id)
//    {
//        List<Map<String, Integer>>  papers_Ids = batchService.SelectBatchPapers(batch_Id);
//        for(Map<String, Integer> paper:papers_Ids)
//        {
//            int papers_id =  paper.get("papers_id");
//            batchService.CopyTargetOptions(papers_id);
//            System.out.println(papers_id);
//        }
////        Map result = new HashMap();
////        int ifCopy = 1;
//        return papers_Ids;
//    }

}
