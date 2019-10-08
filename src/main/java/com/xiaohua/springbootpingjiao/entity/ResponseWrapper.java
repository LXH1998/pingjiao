package com.xiaohua.springbootpingjiao.entity;

/**
 * @ClassName: ResponseWrapper
 * @author:xiaoyi
 * @date: 2019/9/11 23:36
 * @Description : 格式转换 包装
 */
public class ResponseWrapper {
    /**解析接口状态*/
    private String code;
    /**返回提示文本*/
    private String msg;
    /**返回数据长度*/
    private int count;
    /**返回数据*/
    private Object data;

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/17 10:15
     * @param
     * @Description  退出系统
     */
    public static ResponseWrapper loginOutSuccess() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.LOGINOUT.getCode());
        responseWrapper.setMsg(ReturnCode.LOGINOUT.getMsg());
        return responseWrapper;
    }

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/17 10:15
     * @param
     * @Description  插入权限失败
     */
    public static ResponseWrapper insertPowerError() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.ERROR.getCode());
        responseWrapper.setMsg(ReturnCode.ERROR.getMsg());
        return responseWrapper;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/17 10:17
    * @param
    * @Description 插入权限成功
    */
    public static ResponseWrapper insertPowerSucces() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.INSERTSUCCES.getCode());
        responseWrapper.setMsg(ReturnCode.INSERTSUCCES.getMsg());
        return responseWrapper;
    }

    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/17 10:15
     * @param
     * @Description  修改权限失败
     */
    public static ResponseWrapper updataPowerError() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.ERROR.getCode());
        responseWrapper.setMsg(ReturnCode.ERROR.getMsg());
        return responseWrapper;
    }
        /**
        * @Author xiaoyi
        * @Return
        * @Date 2019/9/17 10:15
        * @param
        * @Description  修改权限成功
        */
    public static ResponseWrapper updataPowerSucces(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.UPDATASUCCES.getCode());
        responseWrapper.setMsg(ReturnCode.UPDATASUCCES.getMsg());
        return  responseWrapper;
    }


    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/15 13:55
    * @param
    * @Description 失败
    */
    public static ResponseWrapper deletePowerError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.ERROR.getCode());
        responseWrapper.setMsg(ReturnCode.ERROR.getMsg());
        return  responseWrapper;
    }


    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/15 13:55
     * @param
     * @Description 登录失败
     */
    public static ResponseWrapper loginError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.LOGINERROR.getCode());
        responseWrapper.setMsg(ReturnCode.LOGINERROR.getMsg());
        return  responseWrapper;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/15 13:52
    * @param
    * @Description  删除权限成功
    */
    public static ResponseWrapper deletePowerSuccess(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(0);
        responseWrapper.setCode(ReturnCode.DELETESUCCES.getCode());
        responseWrapper.setMsg(ReturnCode.DELETESUCCES.getMsg());
        return  responseWrapper;
    }

    /**
    * @Author xiaoyi
    * @Return
    * @Date 2019/9/12 17:47
    * @param data 权限列表集合 total 权限条数
    * @Description  查询所有权限成功
    */
    public static ResponseWrapper queryPoewerSuccess(Object data,int total){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(total);
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
        responseWrapper.setData(data);
        return  responseWrapper;
    }


    /**
     * @Author xiaoyi
     * @Return
     * @Date 2019/9/12 17:47
     * @param data 权限列表集合 total 权限条数
     * @Description  查询所有权限成功
     */
    public static ResponseWrapper querySuccess(Object data,int total){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCount(total);
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
        responseWrapper.setData(data);
        return  responseWrapper;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
