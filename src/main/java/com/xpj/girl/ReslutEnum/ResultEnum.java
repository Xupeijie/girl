package com.xpj.girl.ReslutEnum;

/**
 * @Author: xu_peijie
 * @Date: Created in 14:32 on 2017/12/28.
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),
    HIGH_SCHOOL(102,"你超过16岁了")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
