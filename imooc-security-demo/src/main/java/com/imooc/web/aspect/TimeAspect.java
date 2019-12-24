package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 声明切面类
 * @author 何国锋
 * @date 2019-12-22 18:54
 */
@Aspect
@Component
public class TimeAspect {


    /**
     *
     * @param point 切入点对象，他包含了相关的信息(如方法的参数值等)
     * @return object object就是所切入的方法的返回值，直接返回即可
     * @throws Throwable
     */
    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint point) throws Throwable {

        System.out.println("time aspect start");


        //args就是方法的参数列表
        Object[] args = point.getArgs();
        for (Object arg : args) {
            System.out.println("current arg is : " + arg);
        }

        long start = new Date().getTime();
        //跟filterChain.doFilter(servletRequest, servletResponse); 差不多，让他继续执行本该执行的步骤
        Object object = point.proceed();


        System.out.println("time aspect 耗时: " + (new Date().getTime()-start));

        System.out.println("time aspect end");


        return object;
    }

}
