package com.alex.boot.config;

import com.alex.boot.bean.Car;
import com.alex.boot.bean.Pet;
import com.alex.boot.bean.User;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * 1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods， 代理bean的方法
 *  Full(proxyBeanMethods = true)
 *  Lite(proxyBeanMethods = false)
 *  组件依赖：
 *  最佳实战：
 *  - 配置类组件之间无依赖关系用Lite模式加速容器启动过程
 *  - 配置类组件之间有依赖关系，方法会会被表用得到之间单实例组件，用Full模式
 * 4. @Import({User.class, Pet.class})
 *  给容器中自动创建出这两个类型的组件
 */

@Import({User.class, Pet.class})
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类 == 配置文件
@ImportResource("classpath:beans.xml")
// @EnableConfigurationProperties(Car.class)
//1. 开启Car的属性配置
//2. 把这个Car的组件自动注册到容器中
public class MyConfig {

  /**
   * 外部无论对配置类中的这个组件方法调用多少次，获取的都是之前注册在容器中的单例对象
   * @return
   */

  @ConditionalOnBean(name="tom")
  @Bean //给容器中添加组件，以方法名作为组件的id, 返回类型就是组件类型，返回的值，就是组件的在容器中的实例
  public User user01(){
    return new User("张三", 18);
  }

  // @Bean
  public Pet tomcat(){
    return new Pet("Tomcat");
  }
}
