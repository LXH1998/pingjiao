package com.xiaohua.springbootpingjiao.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/9/27 9:42
 * @VERSION: 1.0
 **/

public class TargetOptins {
    private Integer target_Id;
    private String target_Name;
    private Integer options_Id;
    private String options_Content;
    private String options_Weight;

    public Integer getTarget_Id() {
        return target_Id;
    }

    public void setTarget_Id(Integer target_Id) {
        this.target_Id = target_Id;
    }

    public String getTarget_Name() {
        return target_Name;
    }

    public void setTarget_Name(String target_Name) {
        this.target_Name = target_Name;
    }

    public Integer getOptions_Id() {
        return options_Id;
    }

    public void setOptions_Id(Integer options_Id) {
        this.options_Id = options_Id;
    }

    public String getOptions_Content() {
        return options_Content;
    }

    public void setOptions_Content(String options_Content) {
        this.options_Content = options_Content;
    }

    public String getOptions_Weight() {
        return options_Weight;
    }

    public void setOptions_Weight(String options_Weight) {
        this.options_Weight = options_Weight;
    }
}
