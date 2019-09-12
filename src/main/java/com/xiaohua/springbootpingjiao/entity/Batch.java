package com.xiaohua.springbootpingjiao.entity;

public class Batch{
    private Integer batch_Id;
    private String batch_Name;
    private String batch_Hide;

    public Integer getBatch_Id() {
        return batch_Id;
    }

    public void setBatch_Id(Integer batch_Id) {
        this.batch_Id = batch_Id;
    }

    public String getBatch_Name() {
        return batch_Name;
    }

    public void setBatch_Name(String batch_Name) {
        this.batch_Name = batch_Name;
    }

    public String getBatch_Hide() {
        return batch_Hide;
    }

    public void setBatch_Hide(String batch_Hide) {
        this.batch_Hide = batch_Hide;
    }
}
