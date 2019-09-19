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
     int updaePowerState(Power p);
     List<Power> queryTreePower();
}
