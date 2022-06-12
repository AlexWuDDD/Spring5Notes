package com.alex.webadmin.servlet;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true) //保证依赖的组件始终是单实例的
public class MyRegistConfig {
  
  @Bean
  public ServletRegistrationBean myServlet(){
    MyServlet myServlet = new MyServlet();
    return new ServletRegistrationBean<>(myServlet, "/my");
  }

  @Bean
  public FilterRegistrationBean myFilter(){
    MyFilter myFilter = new MyFilter();
    // return new FilterRegistrationBean<>(myFilter, myServlet());
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
    return filterRegistrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean myListener(){
    MyServletContextListener myServletContextListener = new MyServletContextListener();
    return new ServletListenerRegistrationBean<>(myServletContextListener);
  }
}
