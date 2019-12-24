package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;

import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 何国锋
 * @date 2019-12-22 17:22
 */
/*
    表示这是一个配置类，在这里注册@Bean，达到和在web.xml配置组件或者在spring配置文件里面配置组件一样的效果
    添加Interceptor需要继承WebMvcConfigurerAdapter，但是在SpringBoot2.0中已经过时，改为实现WebMvcConfigurer接口或者继承WebMvcConfigurationSupport(推荐)
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    //因为是添加了@Component注解，所以选择自动织入，不加注解的话或者是第三方库，还是选择new一个吧
    @Autowired
    private TimeInterceptor timeInterceptor;

    /**
     * 以配置自己的TimeFilter为例，其他的第三方的Filter同样这样配置
     * @return 注册的filter的实例
     */
    @Bean
    public FilterRegistrationBean timeFilter(){

        //创建一个 FilterRegistrationBean对象，设置他的filter为我们的TimeFilter的实例对象
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        //还可以选择指定的URL触发这个filter
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //用注册器添加需要新增的interceptor的实例
        registry.addInterceptor(timeInterceptor);
    }
}
