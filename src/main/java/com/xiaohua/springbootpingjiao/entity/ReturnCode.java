package com.xiaohua.springbootpingjiao.entity;
/**
 * @ClassName: ReturnCode
 * @author:xiaoyi
 * @date: 2019/9/11 23:36
 * @Description :  返回码
 */
public enum ReturnCode {
    SUCCESS("0000","查询成功"),
    ERROR("0001","失败"),
    DELETESUCCES("0002","删除成功"),
    UPDATASUCCES("0003","修改成功"),
    INSERTSUCCES("0004","插入成功");


    private String code;
    private String msg;
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
