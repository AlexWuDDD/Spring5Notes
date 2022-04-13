package alex.com.aopconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"alex.com"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
    
}
