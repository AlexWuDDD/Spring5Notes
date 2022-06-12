package com.alex.webadmin.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @WebListener
public class MyServletContextListener implements ServletContextListener{
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.info("MyServletContextListener监听到项目初始化完成");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    log.info("MyServletContextListener监听到项目销毁");
  }
}
