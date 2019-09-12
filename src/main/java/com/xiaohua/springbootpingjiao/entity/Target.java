package com.xiaohua.springbootpingjiao.entity;

public class Target{
    private Integer target_Id;
    private String target_Name;
    private String target_Weight;
    private Integer parent_Id;
    private Integer leafs_Id;
    private Integer hides_Id;

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

    public String getTarget_Weight() {
        return target_Weight;
    }

    public void setTarget_Weight(String target_Weight) {
        this.target_Weight = target_Weight;
    }

    public Integer getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(Integer parent_Id) {
        this.parent_Id = parent_Id;
    }

    public Integer getLeafs_Id() {
        return leafs_Id;
    }

    public void setLeafs_Id(Integer leafs_Id) {
        this.leafs_Id = leafs_Id;
    }

    public Integer getHides_Id() {
        return hides_Id;
    }

    public void setHides_Id(Integer hides_Id) {
        this.hides_Id = hides_Id;
    }
}
