package com.xiaohua.springbootpingjiao.entity;

/**
 * 授课信息数据中间类
 * @author langxiaohua
 * @version 1.0
 * @date 2019/9/17 0017 23:46
 */
public class TeachData {
    private Integer teach_id;
    private String class_Name;

    public Integer getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(Integer teach_id) {
        this.teach_id = teach_id;
    }

    public String getClass_Name() {
        return class_Name;
    }

    public void setClass_Name(String class_Name) {
        this.class_Name = class_Name;
    }

    public String getCourses_Name() {
        return courses_Name;
    }

    public void setCourses_Name(String courses_Name) {
        this.courses_Name = courses_Name;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    private String courses_Name;
    private String user_Name;
}
