package com.imooc.web.filter;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 辅助记录服务所耗时间 就是普通的Filter
 * @author 何国锋
 * @date 2019-12-22 17:06
 */
//@Component
public class TimeFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");

        long start = new Date().getTime();

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("time filter 耗时: " + (new Date().getTime()-start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
