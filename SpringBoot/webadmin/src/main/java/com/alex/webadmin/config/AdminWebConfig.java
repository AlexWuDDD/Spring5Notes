package com.alex.webadmin.config;

import com.alex.webadmin.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer{
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**") //所有请求资源都会拦截，包括静态资源
        .excludePathPatterns("/","/login", "/css/**", "/js/**", "/images/**", "/fonts/**"); 
  }
}
