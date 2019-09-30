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
}
