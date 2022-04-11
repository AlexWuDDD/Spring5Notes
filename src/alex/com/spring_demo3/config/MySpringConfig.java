package alex.com.spring_demo3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"alex.com.spring_demo3"})
public class MySpringConfig {
    
}
