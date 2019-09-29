package com.xiaohua.springbootpingjiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: StatisticalController
 * @author:xiaoyi
 * @date: 2019/9/28 15:16
 * @Description : 统计分析Controller
 */
@Controller
@RequestMapping("stats")
public class StatsController {
    @RequestMapping("goIndex")
    public String goStatsIndex(){
        return "/admin/stats/stats_index";
    }
}
