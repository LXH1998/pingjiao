package com.xiaohua.springbootpingjiao.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/9 10:25
 * @VERSION: 1.0
 **/

public class TargetHistory {
    private Integer targethistory_id;
    private Integer target_id;
    private String target_name;
    private String target_weight;
    private Integer batch_id;
    private Integer papers_id;

    public Integer getTargethistory_id() {
        return targethistory_id;
    }

    public void setTargethistory_id(Integer targethistory_id) {
        this.targethistory_id = targethistory_id;
    }

    public Integer getTarget_id() {
        return target_id;
    }

    public void setTarget_id(Integer target_id) {
        this.target_id = target_id;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }

    public String getTarget_weight() {
        return target_weight;
    }

    public void setTarget_weight(String target_weight) {
        this.target_weight = target_weight;
    }

    public Integer getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Integer batch_id) {
        this.batch_id = batch_id;
    }

    public Integer getPapers_id() {
        return papers_id;
    }

    public void setPapers_id(Integer papers_id) {
        this.papers_id = papers_id;
    }
}
