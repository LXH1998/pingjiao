package com.xiaohua.springbootpingjiao.entity;

/**
 * @ClassName: WaterPojo
 * @author:xiaoyi
 * @date: 2019/10/4 17:08
 * @Description :
 */
public class WaterPojo {
    /**流水表ID*/
    Integer fraction_id;
    /**评价得分*/
    double fractions;
    /**评价者角色名称*/
    String role_name;
    Integer rater;
    /**被评价人ID*/
    Integer user_id;
    /**批次ID*/
    String batch_id;
    /**填写试卷ID*/
    Integer papers_id;
    /**课程ID*/
    Integer courses_id;

    public Integer getRater() {
        return rater;
    }

    public void setRater(Integer rater) {
        this.rater = rater;
    }


    public Integer getFraction_id() {
        return fraction_id;
    }

    public void setFraction_id(Integer fraction_id) {
        this.fraction_id = fraction_id;
    }


    public double getFractions() {
        return fractions;
    }

    public void setFractions(double fractions) {
        this.fractions = fractions;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public Integer getPapers_id() {
        return papers_id;
    }

    public void setPapers_id(Integer papers_id) {
        this.papers_id = papers_id;
    }

    public Integer getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(Integer courses_id) {
        this.courses_id = courses_id;
    }
}
