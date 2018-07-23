package com.xpj.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用AOP处理请求
 * Created by peiji on 2017/12/27.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //切哪个点
    @Pointcut("execution(public * com.xpj.girl.controller.GirlController.*(..))")
    public void log(){
    }


    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //method
        logger.info("method={}",request.getMethod());
        //参数
        logger.info("args={}",joinpoint.getArgs());
        //类方法
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName() +"."+ joinpoint.getSignature().getName());
    }

    @After("log()")
    public void doAfter(){

    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        //比较有用
//        logger.info("response={}",object.toString());
    }
}
