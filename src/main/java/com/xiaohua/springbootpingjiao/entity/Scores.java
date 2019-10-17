package com.xiaohua.springbootpingjiao.entity;

public class Scores{
    private Integer scores_Id;
    private Integer gradeds_Id;
    private Double scores_Sum;
    private Integer papers_Id;
    private Integer batch_Id;
    private double teahcer_sum;
    private double students_sum;
    private  double teacher_self;

    public double getTeacher_self() {
        return teacher_self;
    }

    public void setTeacher_self(double teacher_self) {
        this.teacher_self = teacher_self;
    }

    public double getTeahcer_sum() {
        return teahcer_sum;
    }

    public void setTeahcer_sum(double teahcer_sum) {
        this.teahcer_sum = teahcer_sum;
    }

    public double getStudents_sum() {
        return students_sum;
    }

    public void setStudents_sum(double students_sum) {
        this.students_sum = students_sum;
    }

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

    public Double getScores_Sum() {
        return scores_Sum;
    }

    public void setScores_Sum(Double scores_Sum) {
        this.scores_Sum = scores_Sum;
    }

    public Integer getPapers_Id() {
        return papers_Id;
    }

    public void setPapers_Id(Integer papers_Id) {
        this.papers_Id = papers_Id;
    }

    public Integer getBatch_Id() {
        return batch_Id;
    }

    public void setBatch_Id(Integer batch_Id) {
        this.batch_Id = batch_Id;
    }

    public Integer getPapers_id() {
        return papers_Id;
    }

    public void setPapers_id(Integer papers_id) {
        this.papers_Id = papers_id;
    }
}
