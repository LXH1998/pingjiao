package com.xiaohua.springbootpingjiao.service;

import com.xiaohua.springbootpingjiao.entity.Paging;
import com.xiaohua.springbootpingjiao.entity.Power;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PowerInterface {
    List<Power> queryPermissionsAll(Paging paging);
    String queryPowerCount();
    int deletePower(String power_id);
    int updaePower(Power power);
    List<Power> queryFuzzyPower(HashMap p);
    List<Power> fuzzPowerSize(String p);
    List<Map<String, Object>> queryRolePower(Integer user_id);
    boolean insertPower(Power P);
    boolean updaePowerState(Power p);
    List<Power> queryTreePower();
}
