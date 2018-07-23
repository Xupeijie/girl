package com.xpj.girl.exception;

import com.xpj.girl.ReslutEnum.ResultEnum;

/**
 * @Author: xu_peijie
 * @Date: Created in 17:40 on 2017/12/27.
 */
//spring只对RuntimeException进行事物的回滚
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
