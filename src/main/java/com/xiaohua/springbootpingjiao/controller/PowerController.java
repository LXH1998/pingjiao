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
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        return "admin/power/powerInsert";
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
        return "admin/power/powerEdit";
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
        return "admin/power/power_index";
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
        if (sort.isEmpty()){
            power.setSort(null);
        }else {
            power.setSort(Integer.parseInt(sort));
        }
        if (power_parentid.isEmpty()){
            power.setPower_parentid(0);
        }else {
            power.setSort(Integer.parseInt(sort));
        }
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
    @RequestMapping("updatePowerState")
    public ResponseWrapper updatePowerState(int power_id,int state){
        Power p = new Power();
        p.setPower_Id(power_id);
        p.setPower_state(state);
        boolean flag = false;
        boolean result = false;
        List res = service.selectDD(p);
        if (res.size()>0){
             flag = service.updateChilderPowerState(p);
        }else {
            result =  service.updatePowerState(p);
        }
        if (flag){
            result = service.updatePowerState(p);
        }
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
        int user_id;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
        HttpSession  session = request.getSession();
        if(session.getAttribute("user_id") != null){
             user_id = (int)session.getAttribute("user_id");
        } else {
            return ResponseWrapper.loginError();
        }
        List<Map<String, Object>> data = service.queryRolePower(user_id);
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

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/24 9:02
    * @param
    * @Description
    */
    @ResponseBody
    @RequestMapping(value = "/queryPowerAll")
    public ResponseWrapper queryPowerAll(String key){
        if(key==""){
            key=null;
        }
        List<Power> data = service.queryPowerAll(key);
        String size  = service.queryPowerCount();
        int count = Integer.parseInt(size);
        return ResponseWrapper.queryPoewerSuccess(data,count);
    }



    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/15 13:49
     * @param
     * @Description 删除某节点的所有子节点
     */
    @ResponseBody
    @RequestMapping("deletePower")
    public ResponseWrapper deletePower(String power_id){
        int result = service.deleteChilderPower(power_id);
        int flag = service.deletePower(power_id);
        if(result>0&&flag>0){
            return  ResponseWrapper.deletePowerSuccess();
        }
        return ResponseWrapper.deletePowerError();
    }


    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/24 22:09
    * @param
    * @Description  查询所有权限用于下拉框
    */
    @ResponseBody
    @RequestMapping(value = "/queryPowerSelected")
    public List queryPowerSelected(){
        List<Map<String, Object>> data = service.queryPowerSelected();
        return data;
    }

}
