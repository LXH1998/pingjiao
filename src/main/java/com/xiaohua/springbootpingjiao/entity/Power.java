package com.xiaohua.springbootpingjiao.entity;

public class Power{
    private Integer power_Id;
    private String power_Name;
    private String power_url;
    private Integer power_parentid;
    private Integer power_state;
    private String describe;
    private  Integer sort;


    
    public Integer getPower_parentid() {
        return power_parentid;
    }

    public void setPower_parentid(Integer power_parentid) {
        this.power_parentid = power_parentid;
    }

    public Integer getPower_state() {
        return power_state;
    }

    public void setPower_state(Integer power_state) {
        this.power_state = power_state;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public Integer getPower_Id() {
        return power_Id;
    }

    public void setPower_Id(Integer power_Id) {
        this.power_Id = power_Id;
    }

    public String getPower_Name() {
        return power_Name;
    }

    public void setPower_Name(String power_Name) {
        this.power_Name = power_Name;
    }

    public String getPower_url() {
        return power_url;
    }

    public void setPower_url(String power_url) {
        this.power_url = power_url;
    }
}
