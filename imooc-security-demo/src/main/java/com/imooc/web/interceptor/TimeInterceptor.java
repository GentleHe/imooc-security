package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author 何国锋
 * @date 2019-12-22 17:46
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {


    //控制器方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");

        //打印类名，方法名
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        request.setAttribute("startTime", new Date().getTime());

        return true;
    }

    //控制器方法调用正常完成之后，若抛出异常，不执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

        //取出执行前的时间，和当前时间相减，得到处理耗时
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时: " + (new Date().getTime() - start));



    }

    //无论是否正常完成，都执行
    //多说一句，如果由异常处理器@ControllerAdvice所捕获且处理的话，是作为正常执行的
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


        //异常为空，表示正常执行，就不必重复输出了。。
        if (ex != null) {
            System.out.println("ex is : " + ex);
            System.out.println("after completion");
            //取出执行前的时间，和当前时间相减，得到处理耗时
            Long start = (Long) request.getAttribute("startTime");
            System.out.println("time interceptor 耗时: " + (new Date().getTime() - start));
        }



    }
}
