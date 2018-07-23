package com.xpj.girl.handle;

import com.xpj.girl.exception.GirlException;
import com.xpj.girl.pojo.Result;
import com.xpj.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 为了统一异常处理，编写了这个捕获异常的类
 * @Author: xu_peijie
 * @Date: Created in 17:27 on 2017/12/27.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException eg = (GirlException)e;
            return ResultUtil.error(eg.getCode(),eg.getMessage());
        }else{
            logger.error("系统异常{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
