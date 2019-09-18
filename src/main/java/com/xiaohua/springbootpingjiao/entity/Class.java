package com.xiaohua.springbootpingjiao.entity;

import java.util.List;

public class Class{
    private Integer class_Id;
    private String class_Name;
    private Integer departments_id;
    private Departments departments;

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Integer getDepartments_id() {
        return departments_id;
    }

    public void setDepartments_id(Integer departments_id) {
        this.departments_id = departments_id;
    }

    public Integer getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(Integer class_Id) {
        this.class_Id = class_Id;
    }

    public String getClass_Name() {
        return class_Name;
    }

    public void setClass_Name(String class_Name) {
        this.class_Name = class_Name;
    }
}
