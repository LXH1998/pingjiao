package com.xiaohua.springbootpingjiao.entity;

public class User{
    private Integer user_Id;
    private String user_Name;
    private String user_Sex;
    private String user_Account;
    private String user_Password;
    private Integer departments_Id;
    private Integer class_Id;
    private String user_state;

    public String getUser_Sex() {
        return user_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        this.user_Sex = user_Sex;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Account() {
        return user_Account;
    }

    public void setUser_Account(String user_Account) {
        this.user_Account = user_Account;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public Integer getDepartments_Id() {
        return departments_Id;
    }

    public void setDepartments_Id(Integer departments_Id) {
        this.departments_Id = departments_Id;
    }

    public Integer getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(Integer class_Id) {
        this.class_Id = class_Id;
    }
}
