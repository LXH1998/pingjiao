package com.xiaohua.springbootpingjiao.entity;

public class Userrole{
    private Integer userrole_Id;
    private Integer user_Id;
    private Integer role_Id;

    public Integer getUserrole_Id() {
        return userrole_Id;
    }

    public void setUserrole_Id(Integer userrole_Id) {
        this.userrole_Id = userrole_Id;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public Integer getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(Integer role_Id) {
        this.role_Id = role_Id;
    }
}
