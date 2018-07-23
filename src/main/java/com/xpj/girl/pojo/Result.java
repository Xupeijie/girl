package com.xpj.girl.pojo;

/**
 * @Author: xu_peijie
 * @Date: Created in 16:08 on 2017/12/27.
 */
public class Result<T> {

    private String msg;

    private Integer code;

    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
