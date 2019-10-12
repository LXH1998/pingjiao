package com.xiaohua.springbootpingjiao.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/9 10:30
 * @VERSION: 1.0
 **/

public class OptionsHistory {
    private Integer optionshistory_id;
    private Integer options_id;
    private String options_content;
    private String options_weight;
    private Integer target_id;
    private Integer papers_id;
    private Integer batch_id;

    public Integer getOptionshistory_id() {
        return optionshistory_id;
    }

    public void setOptionshistory_id(Integer optionshistory_id) {
        this.optionshistory_id = optionshistory_id;
    }

    public Integer getOptions_id() {
        return options_id;
    }

    public void setOptions_id(Integer options_id) {
        this.options_id = options_id;
    }

    public String getOptions_content() {
        return options_content;
    }

    public void setOptions_content(String options_content) {
        this.options_content = options_content;
    }

    public String getOptions_weight() {
        return options_weight;
    }

    public void setOptions_weight(String options_weight) {
        this.options_weight = options_weight;
    }

    public Integer getTarget_id() {
        return target_id;
    }

    public void setTarget_id(Integer target_id) {
        this.target_id = target_id;
    }

    public Integer getPapers_id() {
        return papers_id;
    }

    public void setPapers_id(Integer papers_id) {
        this.papers_id = papers_id;
    }

    public Integer getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Integer batch_id) {
        this.batch_id = batch_id;
    }
}
