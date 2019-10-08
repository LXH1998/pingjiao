package com.xiaohua.springbootpingjiao.entity;

public class Scores{
    private Integer scores_Id;
    private Integer gradeds_Id;
    private String scores_Sum;
    private Integer papers_Id;
    private Integer batch_Id;
    public Integer getBatch_id() {
        return batch_Id;
    }

    public void setBatch_id(Integer batch_id) {
        this.batch_Id = batch_id;
    }


    public Integer getScores_Id() {
        return scores_Id;
    }

    public void setScores_Id(Integer scores_Id) {
        this.scores_Id = scores_Id;
    }

    public Integer getGradeds_Id() {
        return gradeds_Id;
    }

    public void setGradeds_Id(Integer gradeds_Id) {
        this.gradeds_Id = gradeds_Id;
    }

    public String getScores_Sum() {
        return scores_Sum;
    }

    public void setScores_Sum(String scores_Sum) {
        this.scores_Sum = scores_Sum;
    }

    public Integer getPapers_id() {
        return papers_Id;
    }

    public void setPapers_id(Integer papers_id) {
        this.papers_Id = papers_id;
    }
}
