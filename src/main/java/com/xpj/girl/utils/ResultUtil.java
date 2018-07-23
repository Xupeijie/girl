package com.xpj.girl.utils;

import com.xpj.girl.pojo.Girl;
import com.xpj.girl.pojo.Result;

/**
 * @Author: xu_peijie
 * @Date: Created in 16:46 on 2017/12/27.
 */
public class ResultUtil {

    //返回成功信息
    public static Result success(Object object){
        Result<Object> result = new Result<>();
        result.setMsg("成功");
        result.setCode(1);
        result.setData(object);
        return result;
    }

    //返回成功信息
    public static Result success(){
        return success(null);
    }

    //返回失败信息
    public static Result error(Integer code,String msg){
        Result result = new Result<>();
        result.setMsg(msg);
        result.setCode(code);
        result.setData(null);
        return result;
    }
}
