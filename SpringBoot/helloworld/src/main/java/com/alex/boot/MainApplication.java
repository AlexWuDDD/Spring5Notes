package com.alex.boot;

import com.alex.boot.bean.Pet;
import com.alex.boot.bean.User;
import com.alex.boot.config.MyConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * 
 * @SpringBootApplication 这是一个SpringbBoot应用
 */
@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    // 1. 返回w我们IOC容器
    ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
    // 2. 获取容器中的组件
    // String[] names = run.getBeanDefinitionNames();
    // for (String name : names) {
    //   System.out.println(name);
    // }

    // 3. 从容器中获取组件
    // User user = run.getBean("user01", User.class);
    // System.out.println(user);

    // Pet pet = run.getBean("tomcat", Pet.class);
    // System.out.println(pet);

    // 4. com.alex.boot.config.MyConfig$$EnhancerBySpringCGLIB$$4a29a600@50756c76
    // MyConfig bean = run.getBean(MyConfig.class);
    // System.out.println(bean);

    // 如果@Configuration(proxyBeanMethods = true) 代理对象调用方法，SpringBoot总会检查这个容器是否在容器中
    // 保持组件单实例
    // User user1 = bean.user01();
    // User user2 = bean.user01();
    // System.out.println(user1 == user2);
    // System.out.println(user == user1);
    // System.out.println(user == user2);

    // String[] beanNamesForType = run.getBeanNamesForType(User.class);
    // for (String beanName : beanNamesForType) {
    //   System.out.println(beanName);
    // }

    boolean tom = run.containsBean("tom");
    System.out.println("容器中tom组件:" + tom);

    boolean user01 = run.containsBean("user01");
    System.out.println("容器中user01组件:" + user01);

    boolean haha = run.containsBean("haha");
    boolean hehe = run.containsBean("hehe");
    System.out.println("haha: " + haha);
    System.out.println("hehe: " + hehe);
  }
}
