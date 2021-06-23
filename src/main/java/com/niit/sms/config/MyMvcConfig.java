package com.niit.sms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/user/login", "/login.html", "/layui/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*System.out.println("配置文件已经生效");*/
        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\Program\\workspace\\Java\\sms\\src\\main\\resources\\static\\images\\");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/stuList.html").setViewName("student/stuList");
        registry.addViewController("/teaList.html").setViewName("teacher/teaList");
        registry.addViewController("/userList.html").setViewName("userList");
        registry.addViewController("/personInfo.html").setViewName("personInfo");
        registry.addViewController("/gradeList.html").setViewName("grade/gradeList");
        registry.addViewController("/clazzList.html").setViewName("clazz/clazzList");
    }
}
