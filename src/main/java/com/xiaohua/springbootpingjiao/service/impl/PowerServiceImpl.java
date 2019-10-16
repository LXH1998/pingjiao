package com.xiaohua.springbootpingjiao.service.impl;

import com.xiaohua.springbootpingjiao.entity.Paging;
import com.xiaohua.springbootpingjiao.entity.Power;
import com.xiaohua.springbootpingjiao.mapper.PowerMapper;
import com.xiaohua.springbootpingjiao.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @PackageName:
 * @ClassName: PowerServiceImpl
 * @author:xiaoyi
 * @date: 2019/9/11 12:13
 * @Description :
 */
@Service
public class PowerServiceImpl  implements PowerService {
    @Autowired
    private PowerMapper powerMapper;


    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/18 10:00
     * @param @Power 权限实体
     * @Description 插入权限
     */
    @Override
    public boolean insertPower(Power p) {
        int reslut = powerMapper.insertPower(p);
        if (reslut>0){
            return  true;
        }
        return  false;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/18 14:48
    * @param
    * @Description 修改权限状态
    */
    @Override
    public boolean updatePowerState(Power p) {
        int result = powerMapper.updatePowerState(p);
        if (result>0){
            return  true;
        }
        return false;
    }

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/18 14:48
     * @param
     * @Description 修改父亲节点下的权限状态
     */
    @Override
    public boolean updateChilderPowerState(Power p) {
        int result = powerMapper.updateChilderPowerState(p);
        if (result>0){
            return  true;
        }
        return false;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/17 19:45
    * @param
    * @Description 模糊查询条数
    */
    @Override
    public List<Power> fuzzPowerSize(String p) {
        return powerMapper.fuzzPowerSize(p);
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/19 14:26
    * @param
    * @Description 查询权限树状表格
    */
    @Override
    public List<Power>  queryTreePower() {
        List<Power> list = powerMapper.queryTreePower();
        return  list;
    }

    @Override
    public List<Power> queryPowerAll(String key) {
        List<Power> list = powerMapper.queryPowerAll(key);
        return  list;
    }




    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/17 22:57
    * @param
    * @Description  角色权限动态查询
    */
    @Override
    public List<Map<String, Object>> queryRolePower(Integer user_id) {
        List<Power> list = powerMapper.queryRolePower(user_id);
        return buildTree(0, list);
    }

    public List<Map<String, Object>> buildTree(Integer pid, List<Power> list){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // 1.边界条件
        List<Power> childList = list.stream().filter(item -> item.getPower_parentid().intValue()==pid).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()){ return result;}

        // 2.前进段
        childList.stream().forEach(item->{
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getPower_Id());
            map.put("title", item.getPower_Name());
            map.put("pid", item.getPower_parentid());
            map.put("href", item.getPower_url());
            map.put("status", item.getPower_state());
            List<Map<String, Object>> childs = buildTree(item.getPower_Id(), list);
            if(!childs.isEmpty()){
                map.put("children", childs);
            }
            result.add(map);
        });
        return result;
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/24 22:08
    * @param
    * @Description 查询所有权限用于下拉框
    */
    @Override
    public List<Map<String, Object>> queryPowerSelected() {
        List<Power> list = powerMapper.queryPowerSelected();
        return selectTree(0, list);
    }

    public List<Map<String, Object>> selectTree(Integer pid, List<Power> list){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // 1.边界条件
        List<Power> childList = list.stream().filter(item -> item.getPower_parentid().intValue()==pid).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()){ return result;}

        // 2.前进段
        childList.stream().forEach(item->{
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getPower_Id());
            map.put("name", item.getPower_Name());
            map.put("parenid", item.getPower_parentid());

            map.put("checked", "true");
            List<Map<String, Object>> childs = selectTree(item.getPower_Id(), list);
            if(!childs.isEmpty()){
                map.put("children", childs);
            }
            result.add(map);
        });

        return result;
    }


    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/17 19:21
    * @param
    * @Description 模糊查询
    */
    @Override
    public List<Power> queryFuzzyPower(HashMap p) {
        return powerMapper.queryFuzzyPower(p);
    }


    /**
    * @Author xiaoyi
    * @Return java.util.List<com.xiaohua.springbootpingjiao.entity.Power>
    * @Date 2019/9/15 13:47
    * @param paging 分页详细
    * @Description 查看所有权限
    */
    @Override
    public List<Power> queryPermissionsAll(Paging paging) {
        return powerMapper.queryPermissionsAll(paging);
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/15 13:47
    * @param
    * @Description 查询可用权限的总条数
    */
    @Override
    public String queryPowerCount() {
        return powerMapper.queryPowerCount();
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/16 20:45
    * @param power 权限属性
    * @Description 修改权限
    */
    @Override
    public int updaePower(Power power) {
        return powerMapper.updaePower(power);
    }

    @Override
    public List<Power> selectDD(Power p) {
        return powerMapper.selectDD(p);
    }
    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/24 16:43
    * @param
    * @Description 删除某节点的所有子节点
    */
    @Override
    public int deleteChilderPower(String power_id) {
        return powerMapper.deleteChilderPower(power_id);
    }



    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/15 13:47
     * @param power_id 权限ID
     * @Description  删除叶子节点权限
     */
    @Override
    public int deletePower(String power_id) {
        return powerMapper.deletePower(power_id) ;
    }

}
