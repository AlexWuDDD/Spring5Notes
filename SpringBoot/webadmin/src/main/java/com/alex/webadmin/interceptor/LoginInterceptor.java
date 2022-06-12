package com.alex.webadmin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * 登录检查
 * 1. 配置好拦截器要拦截哪些请求
 * 2. 把这些配置放在容器中
 * 
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor{
  

  /**
   * 目标方法指行之前
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info("login interceptor preHandle");
    //登录检查
    HttpSession session = request.getSession();
    Object loginUser = session.getAttribute("loginUser");

    if(loginUser != null){  
      log.info("登录了，放行");
      return true;
    }
    else{
      //没有登录，跳转到登录页面
      log.info("没登录，跳转到登录页面");
      request.setAttribute("msg", "请先登录");
      // response.sendRedirect("/");
      request.getRequestDispatcher("/").forward(request, response);
      return false;
    }
  }

  /**
   * 目标方法指行之后
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

    log.info("postHandle执行()", modelAndView);
  }

  /**
   * 页面渲染之后
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    log.info("afterCompletion执行()");
  }
}
