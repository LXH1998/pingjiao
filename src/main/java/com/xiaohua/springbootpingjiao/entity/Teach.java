package com.xiaohua.springbootpingjiao.entity;

import java.util.List;

public class Teach {
    private Integer teach_id;
    private String user_Id;
    private String courses_Id;
    private String class_ID;
    private List<User> users;
    private List<Courses> Coursess;
    private List<Class> Classs;
    public List<Courses> getCoursess() {
        return Coursess;
    }

    public void setCoursess(List<Courses> coursess) {
        Coursess = coursess;
    }

    public List<Class> getClasss() {
        return Classs;
    }

    public void setClasss(List<Class> classs) {
        Classs = classs;
    }


    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Integer getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(Integer teach_id) {
        this.teach_id = teach_id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getCourses_Id() {
        return courses_Id;
    }

    public void setCourses_Id(String courses_Id) {
        this.courses_Id = courses_Id;
    }

    public String getClass_ID() {
        return class_ID;
    }

    public void setClass_ID(String class_ID) {
        this.class_ID = class_ID;
    }



}
