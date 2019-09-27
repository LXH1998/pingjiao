package com.xiaohua.springbootpingjiao.mapper;

import com.xiaohua.springbootpingjiao.entity.Paging;
import com.xiaohua.springbootpingjiao.entity.Power;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PowerMapper {
     List<Power> queryPermissionsAll(Paging paging);
     String queryPowerCount();
     int deletePower(String power_id);
     int updaePower(Power power);
     List<Power> queryFuzzyPower(HashMap p);
     List<Power> fuzzPowerSize(String p);
     List<Power> queryRolePower(Integer user_id);
     int insertPower(Power P);
     int updatePowerState(Power p);
     List<Power> queryTreePower();
     List<Power> queryPowerAll(String key);
     int updateChilderPowerState(Power p);
     /**
      * @param power_id
      * @return  删除树的节点 包含父子
      */
     List<Power> queryChilderPower(String power_id);
     int deleteChilderPower(String power_id);
     /**
      *  查询所有权限用于下拉框
      */
     List<Power> queryPowerSelected();

}
