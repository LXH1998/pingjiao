package com.xiaohua.springbootpingjiao.entity;

public class Usercourses{
    private Integer usercourses_Id;
    private Integer user_Id;
    private Integer courses_Id;

    public Integer getUsercourses_Id() {
        return usercourses_Id;
    }

    public void setUsercourses_Id(Integer usercourses_Id) {
        this.usercourses_Id = usercourses_Id;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public Integer getCourses_Id() {
        return courses_Id;
    }

    public void setCourses_Id(Integer courses_Id) {
        this.courses_Id = courses_Id;
    }
}
