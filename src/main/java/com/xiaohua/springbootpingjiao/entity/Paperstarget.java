package com.xiaohua.springbootpingjiao.entity;

import java.util.List;

public class Paperstarget{
    private Integer paperstarget_Id;
    private Integer papers_Id;
    private Integer target_Id;

    public Integer getPaperstarget_Id() {
        return paperstarget_Id;
    }

    public void setPaperstarget_Id(Integer paperstarget_Id) {
        this.paperstarget_Id = paperstarget_Id;
    }

    public Integer getPapers_Id() {
        return papers_Id;
    }

    public void setPapers_Id(Integer papers_Id) {
        this.papers_Id = papers_Id;
    }

    public Integer getTarget_Id() {
        return target_Id;
    }

    public void setTarget_Id(Integer target_Id) {
        this.target_Id = target_Id;
    }

    private List<Target> targets;
    private List<Options> options;

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
