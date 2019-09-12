package com.xiaohua.springbootpingjiao.entity;

public class Papers{
    private Integer papers_Id;
    private Integer role_Id;
    private Integer batch_Id;
    private String papers_Name;

    public Integer getPapers_Id() {
        return papers_Id;
    }

    public void setPapers_Id(Integer papers_Id) {
        this.papers_Id = papers_Id;
    }

    public Integer getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(Integer role_Id) {
        this.role_Id = role_Id;
    }

    public Integer getBatch_Id() {
        return batch_Id;
    }

    public void setBatch_Id(Integer batch_Id) {
        this.batch_Id = batch_Id;
    }

    public String getPapers_Name() {
        return papers_Name;
    }

    public void setPapers_Name(String papers_Name) {
        this.papers_Name = papers_Name;
    }
}
