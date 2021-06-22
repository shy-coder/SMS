package com.niit.sms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/head/**").addResourceLocations("/head/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/user/login","/login.html","/layui/**","C:/Program/workspace/Java/sms/head/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/stuList.html").setViewName("stuList");
        registry.addViewController("/teaList.html").setViewName("teacher/teaList");
        registry.addViewController("/userList.html").setViewName("userList");
        registry.addViewController("/personInfo.html").setViewName("personInfo");
        registry.addViewController("/gradeList.html").setViewName("gradeList");
        registry.addViewController("/clazzList.html").setViewName("clazzList");
    }
}
