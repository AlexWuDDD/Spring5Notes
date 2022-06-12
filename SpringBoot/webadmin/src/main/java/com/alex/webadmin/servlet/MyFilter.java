package com.alex.webadmin.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @WebFilter(urlPatterns = {"/css/*","/images/*","/js/*","/my"})
public class MyFilter implements Filter{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.info("My filter 初始化完成");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    log.info("MyFilter工作");
    chain.doFilter(request, response);
    
  }

  @Override
  public void destroy() {
    log.info("My filter 销毁完成");
  }
  
}
