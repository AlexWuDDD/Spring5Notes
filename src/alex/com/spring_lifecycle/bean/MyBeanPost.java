package alex.com.spring_lifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class MyBeanPost implements BeanPostProcessor{
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("在我们的初始化之前执行的方法");
        return bean;
	}

    @Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("在我们的初始化之后执行的方法");
        return bean;
	}
}
