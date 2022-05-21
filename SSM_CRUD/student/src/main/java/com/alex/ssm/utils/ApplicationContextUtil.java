package com.alex.ssm.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil{

  public static ApplicationContext getIoc(){
    return new ClassPathXmlApplicationContext("applicationContext.xml");
  }
}