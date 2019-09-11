package com.xiaohua.springbootpingjiao.entity;

public class Fraction{
    private Integer fraction_Id;
    private String fractions;
    private Integer rater;
    private Integer gradeds;
    private Integer paper_Id;
    private Integer courses_Id;
    private String answers;

    public Integer getFraction_Id() {
        return fraction_Id;
    }

    public void setFraction_Id(Integer fraction_Id) {
        this.fraction_Id = fraction_Id;
    }

    public String getFractions() {
        return fractions;
    }

    public void setFractions(String fractions) {
        this.fractions = fractions;
    }

    public Integer getRater() {
        return rater;
    }

    public void setRater(Integer rater) {
        this.rater = rater;
    }

    public Integer getGradeds() {
        return gradeds;
    }

    public void setGradeds(Integer gradeds) {
        this.gradeds = gradeds;
    }

    public Integer getPaper_Id() {
        return paper_Id;
    }

    public void setPaper_Id(Integer paper_Id) {
        this.paper_Id = paper_Id;
    }

    public Integer getCourses_Id() {
        return courses_Id;
    }

    public void setCourses_Id(Integer courses_Id) {
        this.courses_Id = courses_Id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}