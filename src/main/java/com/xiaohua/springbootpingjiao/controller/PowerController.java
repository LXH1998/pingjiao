package com.xiaohua.springbootpingjiao.controller;

import com.xiaohua.springbootpingjiao.entity.Paging;
import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.entity.ResponseWrapper;
import com.xiaohua.springbootpingjiao.entity.ReturnTree;
import com.xiaohua.springbootpingjiao.service.impl.PowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PowerController
 * @author:xiaoyi
 * @date: 2019/9/12 8:40
 * @Description :
 */
@Controller
@RequestMapping("/powerBoot")
public class PowerController {

    @Autowired
    private PowerServiceImpl service;




    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/18 9:06
    * @param
    * @Description  跳转插入权限页面
    */
    @RequestMapping("goPowerInsert")
    public String goPowerInsert(){
        return "power/powerInsert";
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/16 10:03
    * @param
    * @Description 跳转权限修改页面
    */
    @RequestMapping("goPowerEdit")
    public String goPowerEdit(){
        return "power/powerEdit";
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/12 18:18
    * @param
    * @Description 跳转power主页面
    */
    @RequestMapping("goPower")
    public String goPower(){
        return "power/power_index";
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/12 17:38
    * @param
    * @Description 查询所有权限
    */
    @RequestMapping("queryPower")
    @ResponseBody
    public ResponseWrapper powers(String page,String limit){
        Paging paging = new Paging();
        paging.setLimits(Integer.parseInt(limit));
        paging.setPages(Integer.parseInt(page));
        List<Power> powersList = service.queryPermissionsAll(paging);
        String size  = service.queryPowerCount();
        int count = Integer.parseInt(size);
        Object data = powersList;
        return ResponseWrapper.queryPoewerSuccess(data,count);
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/15 13:49
    * @param
    * @Description 删除权限
    */
    @ResponseBody
    @RequestMapping("deletePower")
    public ResponseWrapper deletePower(String power_id){
        int result = service.deletePower(power_id);
        if(result>0){
            return  ResponseWrapper.deletePowerSuccess();
        }
        return ResponseWrapper.deletePowerError();
    }
    /**
    * @Author xiaoyi
    * @Return 
    * @Date 2019/9/16 20:46
    * @param  @ 权限属性
    * @Description 修改权限
    */
    @ResponseBody
    @RequestMapping("updatePower")
    public ResponseWrapper updatePower(String power_Id,String power_Name,String power_url,String power_parentid,String power_state, String describe,String sort ){
        Power power = new Power();
        power.setPower_Id(Integer.parseInt(power_Id));
        power.setPower_Name(power_Name);
        power.setPower_url(power_url);
        power.setPower_parentid(Integer.parseInt(power_parentid));
        power.setPower_state(Integer.parseInt(power_state));
        power.setDescribe(describe);
        power.setSort(Integer.parseInt(sort));
        int result = service.updaePower(power);
        if(result>0){
            return  ResponseWrapper.updataPowerSucces();
        }
        return ResponseWrapper.updataPowerError();
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/17 19:22
    * @param
    * @Description 模糊查询
    */
    @RequestMapping("queryFuzzyPower")
    @ResponseBody
    public ResponseWrapper queryFuzzyPower(int page,int limit,String p){
        int pageing = (page-1)*limit;

        HashMap<String, String> map = new HashMap<>();
        map.put("page",Integer.toString(pageing));
        map.put("limit",Integer.toString(limit));
        map.put("p",p);
        List<Power> powersList = service.queryFuzzyPower(map);
        List<Power> size  = service.fuzzPowerSize(p);
        int count = size.size();
        Object data = powersList;
        return ResponseWrapper.queryPoewerSuccess(data,count);
    }


    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/18 10:06
    * @param
    * @Description 插入权限
    */
    @ResponseBody
    @RequestMapping("insertPower")
    public ResponseWrapper insertPower(Power p){
        boolean result = service.insertPower(p);
        if (result){
            return ResponseWrapper.insertPowerSucces();
        }
        return  ResponseWrapper.insertPowerError();
    }

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/18 10:06
     * @param
     * @Description 修改权限状态
     */
    @ResponseBody
    @RequestMapping("updaePowerState")
    public ResponseWrapper updaePowerState(int power_id,int state){
        Power p = new Power();
        p.setPower_Id(power_id);
        p.setPower_state(state);
        boolean result = service.updaePowerState(p);
        if (result){
            return ResponseWrapper.updataPowerSucces();
        }
        return  ResponseWrapper.updataPowerError();
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/18 15:28
    * @param
    * @Description 查询角色权限
    */
    @ResponseBody
    @RequestMapping(value = "/menu")
    public ResponseWrapper getTreeList(){
        List<Map<String, Object>> data = service.queryRolePower(16);
        return ResponseWrapper.queryPoewerSuccess(data,0);
    }
    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/18 15:28
     * @param
     * @Description 查询角色权限
     */
    @ResponseBody
    @RequestMapping(value = "/queryTreePower")
    public ReturnTree queryTreePower(){
        ReturnTree tree  =  new ReturnTree();
        List<Power> data = service.queryTreePower();
        tree.setCode(1);
        tree.setMsg("222");
        tree.setData(data);
        return tree;
    }

    @RequestMapping("/indexxdd")
    public String indexx(){
        return "power/ces";
    }


}
